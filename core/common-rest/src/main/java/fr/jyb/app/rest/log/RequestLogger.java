package fr.jyb.app.rest.log;

import fr.jyb.app.rest.util.AppRestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 *
 */
@Component
@Slf4j
public class RequestLogger {

    @Autowired
    private AppRestUtil appRestUtil;

    public void logIncomingRequest(HttpServletRequest request, HttpServletResponse response) {
        IncomingRequestLog data = new IncomingRequestLog();
        this.fillInIncomingRequest(data, request, response);
        String dataAsJson = appRestUtil.convertObjectToJson(data).get();
        log.info(dataAsJson);
    }

    public void logOutgoingResponse(HttpServletRequest request, HttpServletResponse response) {
        OutgoingResponseLog data = new OutgoingResponseLog();
        this.fillInOutgoingResponse(data, request, response);
        String dataAsJson = appRestUtil.convertObjectToJson(data).get();
        log.info(dataAsJson);
    }

    private void fillInIncomingRequest(IncomingRequestLog log, HttpServletRequest request, HttpServletResponse response) {
        log.setRequestMethod(request.getMethod());
        log.setRequestUrl(request.getRequestURL().toString());
        log.setRemoteAddr(request.getRemoteAddr());
        log.setRemoteAddrDeclaredByReverseProxy(request.getHeader("X-FORWARDED-FOR"));
        log.setTransactionId(Objects.isNull(request.getAttribute("X-TRANSACTION-ID")) ? null : request.getAttribute("X-TRANSACTION-ID").toString());
        log.setCorrelationId(Objects.isNull(request.getAttribute("X-APP-CORRELATION-ID")) ? null : request.getAttribute("X-APP-CORRELATION-ID").toString());
    }

    private void fillInOutgoingResponse(OutgoingResponseLog log, HttpServletRequest request, HttpServletResponse response) {
        log.setRequestMethod(request.getMethod());
        log.setRequestUrl(request.getRequestURL().toString());
        log.setRemoteAddr(request.getRemoteAddr());
        log.setRemoteAddrDeclaredByReverseProxy(request.getHeader("X-FORWARDED-FOR"));
        log.setTransactionId(Objects.isNull(request.getAttribute("X-TRANSACTION-ID")) ? null : request.getAttribute("X-TRANSACTION-ID").toString());
        log.setCorrelationId(Objects.isNull(request.getAttribute("X-APP-CORRELATION-ID")) ? null : request.getAttribute("X-APP-CORRELATION-ID").toString());

        log.setResponseStatusCode(response.getStatus());

        if ( Objects.nonNull(request.getAttribute("APP_ExecutionTime.Start")) && Objects.nonNull(request.getAttribute("APP_ExecutionTime.End")) ) {
            long start = ((Long)request.getAttribute("APP_ExecutionTime.Start")).longValue();
            long end = ((Long)request.getAttribute("APP_ExecutionTime.End")).longValue();
            long executionTime = end - start;
            log.setExecutionTimeInMillis(executionTime);
        }
    }
}
