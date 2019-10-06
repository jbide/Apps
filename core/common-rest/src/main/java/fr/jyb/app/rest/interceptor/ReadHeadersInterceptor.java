package fr.jyb.app.rest.interceptor;

import fr.jyb.app.rest.log.RequestLogger;
import fr.jyb.app.rest.util.AppRestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 *
 */
@Component
public class ReadHeadersInterceptor implements HandlerInterceptor {

    @Autowired
    private AppRestUtil appRestUtil;

    @Autowired
    private RequestLogger requestLogger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("APP_ExecutionTime.Start", System.currentTimeMillis());

        if ( Objects.isNull(request.getAttribute("X-APP-CORRELATION-ID")) ) {
            if ( Objects.isNull(request.getHeader("X-APP-CORRELATION-ID")) ) {
                request.setAttribute("X-APP-CORRELATION-ID", this.appRestUtil.generateRandomId());
            } else {
                request.setAttribute("X-APP-CORRELATION-ID", request.getHeader("X-APP-CORRELATION-ID"));
            }
        }

        if ( Objects.isNull(request.getAttribute("X-TRANSACTION-ID")) ) {
            request.setAttribute("X-TRANSACTION-ID", this.appRestUtil.generateRandomId());
        }

        this.appRestUtil.setResponseHttpHeaders(request, response);
        this.requestLogger.logIncomingRequest(request, response);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        request.setAttribute("APP_ExecutionTime.End", System.currentTimeMillis());
        this.requestLogger.logOutgoingResponse(request, response);
    }
}
