package christmas.exception.menuvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.ONLYDRINKSEXCEPTION;

public class OnlyDrinksException extends CustomException {
    public OnlyDrinksException(){super(ONLYDRINKSEXCEPTION.getMessage());}

    @Override
    public String getMessage() {
        return ONLYDRINKSEXCEPTION.getMessage();
    }
}

