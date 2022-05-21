package errors;

public enum ErrorMessages {
    PAGE_NOT_OPENED("Page did not open"),
    ELEMENT_NOT_FOUND("Element not found"),
    URL_IS_WRONG("URL is wrong"),
    DESCRIPTION_TEXT_INCORRECT("Description text is incorrect "),
    TITLE_TEXT_INCORRECT("Title text is incorrect "),
    BUTTON_DIDNT_WORK("Button didn't work ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
