package christmas.exception.inputvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.NONSPACEINPUT;

public class ContainSpaceException extends CustomException {

    public ContainSpaceException(){
        super(NONSPACEINPUT.getMessage());
    }


    @Override
    public String getMessage() {
        return NONSPACEINPUT.getMessage();
    }
}
