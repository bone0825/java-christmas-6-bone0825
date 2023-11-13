package christmas.utils;

import christmas.exception.menuvalidator.EmptyOrderException;
import christmas.exception.menuvalidator.IllegalOrderException;
import christmas.exception.menuvalidator.MenuCountOutOfRangeException;
import christmas.exception.menuvalidator.OnlyDrinksException;
import christmas.menu.Menu;

import java.util.List;
import java.util.Map;

public class MenuValidator {

    public static void validtateCountRange(int inputValue){ // 총 메뉴 입력 개수
        if(inputValue > 20 || inputValue <=0 ) throw new MenuCountOutOfRangeException();
    }

    public static void validateMenuFormatSize(String[] inputValues){
        if(inputValues.length != 2) throw new IllegalOrderException();
    }

    public static void validateMenuOnlyDrinks(Map<Map<Menu, Integer>, Integer> orders) {
        for (Map<Menu, Integer> order : orders.keySet()) {
            if(checkMenus(order)) return; //음료가 아닌 항목이 검색되면 return
        }
        throw new OnlyDrinksException();// 음료수만 있는 경우 예외 던지기
    }

    private static boolean checkMenus(Map<Menu,Integer> order) {
        for (Menu menu : order.keySet()) {
            if (!checkOrder(menu)) {return true;} // 음료수가 아닌 항목이 포함된 경우 return true;
        }
        return false;
    }

    private static boolean checkOrder(Menu menu) {
        return menu.getType().equals("Drinks");
    }

}
