package christmas.utils;

import christmas.exception.menuvalidator.NoMenuException;
import christmas.menu.Menu;

import java.util.*;

public class StringUtil {

    public static int stringToInt(String inputValue) {
        InputValidator.validateContainSpace(inputValue); // 공백 검사
        InputValidator.validateAmountNotNumber(inputValue); //숫자 검사
        return Integer.parseInt(inputValue);
    }

    public static Map<Map<Menu,Integer>, Integer> stringToMap(String inputValue) {
        List<String> tempMenu = stringToList(inputValue);
        MenuValidator.validateEmptyMenu(tempMenu);
        return listToMap(tempMenu);
    }

    private static List<String> stringToList(String inputValue) {
        InputValidator.validateContainSpace(inputValue); //공백 검사
        InputValidator.validateDashSeparate(inputValue); //"-" 존재 검사
        return Arrays.asList(inputValue.split(",",-1));
    }


    private static Map<Map<Menu,Integer>, Integer> listToMap(List<String> menus) {
        Map<Map<Menu, Integer>, Integer> tempMenuAndCount = new HashMap<>();
        int checkTotalCount = 0;
        for (String menu : menus) {
            String[] temp = menu.split("-");
            MenuValidator.validateMenuFormatSize(temp);
            InputValidator.validateAmountNotNumber(temp[1]);
            tempMenuAndCount.put(getMenuItem(temp[0]), Integer.parseInt(temp[1]));
            checkTotalCount += Integer.parseInt(temp[1]);
        }
        MenuValidator.validtateCountRange(checkTotalCount);

        return tempMenuAndCount;
    }

    private static Map<Menu,Integer> getMenuItem(String s) {
        return containMenuItem(s, Menu.values());
    }

    private static Map<Menu,Integer> containMenuItem(String input, Menu[] menus) { //속해 있는 메뉴의 값 리턴
        Map<Menu,Integer> menuAndNumber = new HashMap<>();
        for (Menu menuItem : menus) {
            if (menuItem.getAllMenus().contains(input)) {
                menuAndNumber.put(menuItem,menuItem.getAllMenus().indexOf(input));
                return menuAndNumber;
            }
        }
        throw new NoMenuException();
    }
}
