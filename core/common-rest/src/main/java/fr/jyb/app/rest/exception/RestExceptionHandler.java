package fr.jyb.app.rest.exception;

import fr.jyb.app.rest.dto.ErrorDTO;
import fr.jyb.myapp.service.domain.ErrorCatalog;
import fr.jyb.myapp.service.exception.ServiceException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<?> handleServiceException(ServiceException serviceException) {
        return ResponseEntity.status(getStatus(serviceException))
                .body(buildErrorDto(serviceException));

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllExceptions(Exception exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(ErrorCatalog.APPLICATION_ERROR.getCode(),
                        ErrorCatalog.APPLICATION_ERROR.getMessage()));
    }

    private ErrorDTO buildErrorDto(ServiceException serviceException) {
        String code = serviceException.getErrorCatalog().getCode();
        String message = serviceException.getMessage();
        return new ErrorDTO(code, message);
    }

    private HttpStatus getStatus(ServiceException serviceException) {
        return HttpStatus.OK;
    }
}
