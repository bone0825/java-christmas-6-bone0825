package christmas.utils;

import christmas.menu.Menu;

import java.util.*;

public class StringUtil {

    public static int stringToInt(String inputValue) {
        InputValidator.validateAmountNotNumber(inputValue); //유효성 검사 불통시 NonNumericInputException()
        return Integer.parseInt(inputValue);
    }


}
