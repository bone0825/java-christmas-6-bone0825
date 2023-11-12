package christmas.exception.inputvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.OUTOFDAYEXCEPTION;

public class OutOfDayException extends CustomException {
    public OutOfDayException(){super(OUTOFDAYEXCEPTION.getMessage());}

    @Override
    public String getMessage() {return OUTOFDAYEXCEPTION.getMessage(); }
}
