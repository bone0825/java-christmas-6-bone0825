package christmas.exception.inputvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.NONNUMERICINPUT;

public class NonNumericInputException extends CustomException {

    public NonNumericInputException(){super(NONNUMERICINPUT.getMessage());}

    @Override
    public String getMessage() {
        return NONNUMERICINPUT.getMessage();
    }
}
