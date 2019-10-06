package fr.jyb.myapp.service.exception;

import fr.jyb.myapp.service.domain.ErrorCatalog;
import fr.jyb.myapp.service.domain.ErrorOrigin;

/**
 *
 */
public class ServiceException extends RuntimeException {

    private ErrorCatalog errorCatalog;
    private ErrorOrigin errorOrigin;

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(ErrorCatalog errorCatalog, ErrorOrigin errorOrigin, String message, Throwable cause) {
        super(message, cause);
        this.errorCatalog = errorCatalog;
        this.errorOrigin = errorOrigin;
    }

    public ServiceException(ErrorCatalog errorCatalog, ErrorOrigin errorOrigin) {
        this(errorCatalog, errorOrigin, null, null);
    }

    public ServiceException(ErrorCatalog errorCatalog, ErrorOrigin errorOrigin, Throwable cause) {
        this(errorCatalog, errorOrigin, null, cause);
    }

    public ServiceException(ErrorCatalog errorCatalog, ErrorOrigin errorOrigin, String message) {
        this(errorCatalog, errorOrigin, message, null);
    }

    public ErrorCatalog getErrorCatalog() {
        return errorCatalog;
    }

    public ErrorOrigin getErrorOrigin() {
        return errorOrigin;
    }
}
