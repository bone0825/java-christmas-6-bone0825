package christmas.exception.inputvalidator;

import christmas.exception.CustomException;

import static christmas.exception.ErrorMessage.ILLEGALDAYeXCEPTION;

public class ILLEGALDAYeXCEPTION extends CustomException {
    public ILLEGALDAYeXCEPTION(){super(ILLEGALDAYeXCEPTION.getMessage());}

    @Override
    public String getMessage() {return ILLEGALDAYeXCEPTION.getMessage(); }
}
