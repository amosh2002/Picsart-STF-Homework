package errors;

public enum ErrorMessages {
    PAGE_NOT_OPENED("Page did not open"),
    ELEMENT_NOT_FOUND("Element not found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
