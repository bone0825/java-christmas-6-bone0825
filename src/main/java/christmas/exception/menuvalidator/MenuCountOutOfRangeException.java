package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.MENUCOUNTOUTOFRANGE;

public class MenuCountOutOfRangeException extends CustomException {
    public MenuCountOutOfRangeException(){
        super(MENUCOUNTOUTOFRANGE.getMessage());
    }


    @Override
    public String getMessage() {
        return MENUCOUNTOUTOFRANGE.getMessage();
    }
}
