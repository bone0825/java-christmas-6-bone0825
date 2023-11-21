package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.MENUCOUNTZEROEXCEPTION;

public class MenuCountZeroException extends CustomException {
    public MenuCountZeroException(){
        super(MENUCOUNTZEROEXCEPTION.getMessage());
    }


    @Override
    public String getMessage() {
        return MENUCOUNTZEROEXCEPTION.getMessage();
    }
}
