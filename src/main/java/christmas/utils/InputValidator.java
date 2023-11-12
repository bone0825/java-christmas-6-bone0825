package christmas.utils;

import christmas.exception.inputvalidator.OutOfDayException;
import christmas.exception.menuvalidator.IllegalOrderException;
import christmas.exception.inputvalidator.NonNumericInputException;
import christmas.exception.inputvalidator.ContainSpaceException;

public class InputValidator {

    public static void validateAmountNotNumber(String inputValue) {//숫자 유뮤 확인
        if (!inputValue.matches("\\d+")) throw new NonNumericInputException();
    }

    public static void validateContainSpace(String inputValue){ //공백 유뮤 확인
        if(inputValue.contains(" ") || inputValue.isEmpty()) throw new ContainSpaceException();
    }

    public static void validateDashSeparate(String order) { //메뉴 입력 양식 확인
        if (!order.contains("-")) throw new IllegalOrderException();
    }

    public static void validateDayRange(int inputValue){
        if (inputValue > 31 || inputValue <= 0 ) throw new OutOfDayException();
    }






}
