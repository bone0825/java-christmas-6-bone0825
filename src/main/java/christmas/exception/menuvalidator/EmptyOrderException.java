package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.EMPTYORDEREXCEPTION;

public class EmptyOrderException extends CustomException {

    public EmptyOrderException(){
        super(EMPTYORDEREXCEPTION.getMessage());
    }


    @Override
    public String getMessage() {
        return EMPTYORDEREXCEPTION.getMessage();
    }

}
