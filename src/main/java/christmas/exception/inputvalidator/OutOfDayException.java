package christmas.exception.inputvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.ILLEGALDAYEXCEPTION;

public class OutOfDayException extends CustomException {
    public OutOfDayException(){super(ILLEGALDAYEXCEPTION.getMessage());}

    @Override
    public String getMessage() {return ILLEGALDAYEXCEPTION.getMessage(); }
}
