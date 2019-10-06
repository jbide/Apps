package fr.jyb.myapp.service.domain;

/**
 *
 */
public enum ErrorCatalog {

    TOURNEES_DOES_NOT_EXIST("101", "No tournees found", ErrorType.FUNCTIONAL),
    TOURNEE_TITLE_NOT_VALID("102", "Title of tournee not valid", ErrorType.FUNCTIONAL),
    TOURNEE_EMPTY("103", "Tournee is empty", ErrorType.FUNCTIONAL),

    FAMILLE_ARTICLE_NOM_NOT_VALID("202", "Famille article name is not valid", ErrorType.FUNCTIONAL),

    APPLICATION_ERROR("400", "Unexpected error", ErrorType.TECHNICAL),
    NO_RECORD_FOUND("600", "No records found", ErrorType.FUNCTIONAL);

    private String code;
    private String message;
    private ErrorType errorType;

    ErrorCatalog(String code, String message, ErrorType errorType) {
        this.code = code;
        this.message = message;
        this.errorType = errorType;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }
}
