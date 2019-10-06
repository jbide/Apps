package fr.jyb.app.rest.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 *
 */
@Component
@Slf4j
public class LogContextInitInterceptor implements HandlerInterceptor {

    private final String TRANSACTION_ID = "TRANSACTION_ID";
    private final String APP_CLIENT_CODE = "APP_CLIENT_CODE";
    private final String APP_CLIENT_NAME = "APP_CLIENT_NAME";
    private final String TOKEN_CLIENT_CODE = "TOKEN_CLIENT_CODE";
    private final String SERVICE_NAME = "SERVICE_NAME";
    private final String CORRELATION_ID = "CORRELATION-ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("Log context init");

        this.insertMDCDatas(request);

        log.info("Log context init End");

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("clear MDC");
        this.clearMDCDatas();
    }

    private void insertMDCDatas(HttpServletRequest request) {
        String serviceName = request.getRequestURI();
        String appClientCode = request.getHeader("X-APP-CLIENT-CODE");
        String appClientName = request.getHeader("X-APP-CLIENT-NAME");
        String correlationId = request.getAttribute("X-APP-CORRELATION-ID").toString();
        String tokenClientCode = "";
        String transactionId = request.getAttribute("X-TRANSACTION-ID").toString();

        MDC.put(TRANSACTION_ID, transactionId);
        MDC.put(APP_CLIENT_CODE, "A20");
        MDC.put(APP_CLIENT_NAME, "RemoteUi");
        MDC.put(TOKEN_CLIENT_CODE, tokenClientCode);
        MDC.put(SERVICE_NAME, serviceName);
        MDC.put(CORRELATION_ID, correlationId);
    }

    private void clearMDCDatas() {
        MDC.remove(TRANSACTION_ID);
        MDC.remove(APP_CLIENT_CODE);
        MDC.remove(APP_CLIENT_NAME);
        MDC.remove(TOKEN_CLIENT_CODE);
        MDC.remove(SERVICE_NAME);
        MDC.remove(CORRELATION_ID);
    }
}
