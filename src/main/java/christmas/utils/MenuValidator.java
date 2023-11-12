package christmas.utils;

import christmas.exception.menuvalidator.IllegalOrderException;
import christmas.exception.menuvalidator.MenuCountOutOfRangeException;

public class MenuValidator {

    public static void validtateCountRange(int inputValue){ // 총 메뉴 입력 개수
        if(inputValue > 20 || inputValue <=0 ) throw new MenuCountOutOfRangeException();
    }

    public static void validateMenuFormatSize(String[] temp){
        if(temp.length != 2) throw new IllegalOrderException();
    }
}
