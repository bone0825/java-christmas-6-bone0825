package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.ILLEGALORDERINPUT;

public class IllegalOrderException extends CustomException {

    public IllegalOrderException(){
        super(ILLEGALORDERINPUT.getMessage());
    }


    @Override
    public String getMessage() {
        return ILLEGALORDERINPUT.getMessage();
    }

}
