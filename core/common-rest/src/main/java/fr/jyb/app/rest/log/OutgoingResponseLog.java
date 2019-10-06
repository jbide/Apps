package fr.jyb.app.rest.log;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
public class OutgoingResponseLog {

    private String logType = "OUTGOING_REQUEST";
    private String requestMethod;
    private String requestUrl;
    private String remoteAddr;
    private String remoteAddrDeclaredByReverseProxy;
    private String transactionId;
    private String correlationId;

    private int responseStatusCode;
    private long executionTimeInMillis;
}
