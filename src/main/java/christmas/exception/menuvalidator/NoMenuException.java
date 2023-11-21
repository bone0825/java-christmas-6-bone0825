package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.MENUNOTEXIST;

public class NoMenuException extends CustomException {
    public NoMenuException(){
        super(MENUNOTEXIST.getMessage());
    }


    @Override
    public String getMessage() {
        return MENUNOTEXIST.getMessage();
    }
}
