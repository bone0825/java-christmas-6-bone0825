package christmas.exception;

public abstract class CustomException extends IllegalArgumentException {

    public abstract String getMessage();

    public CustomException(String message) {
        super(message);
    }

}
