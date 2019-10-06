package fr.jyb.app.rest.log;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
public class IncomingRequestLog {

    private String logType = "INCOMING_REQUEST";
    private String requestMethod;
    private String requestUrl;
    private String remoteAddr;
    private String remoteAddrDeclaredByReverseProxy;
    private String transactionId;
    private String correlationId;
}
