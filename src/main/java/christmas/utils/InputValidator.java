package christmas.utils;

import christmas.exception.inputvalidator.IllegalOrderException;
import christmas.exception.inputvalidator.NoMenuException;
import christmas.exception.inputvalidator.NonNumericInputException;
import christmas.exception.inputvalidator.ContainSpaceException;

import christmas.menu.*;
import com.sun.tools.javac.Main;


import java.util.ArrayList;
import java.util.List;


public class InputValidator {
    public static void validateAmountNotNumber(String inputValue) {//숫자 유뮤 확인
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }

    public static void validateContainSpace(String inputValue){ //공백 유뮤 확인
        if(inputValue.contains(" ")) throw new ContainSpaceException();
    }


    public static void validateMenuForm(String order) { //메뉴 입력 양식 확인
        if (!order.contains("-")) throw new IllegalOrderException();
        if (!order.contains(",")) throw new IllegalOrderException();
    }

    public static Menu validateMenuInput(String s) {//어디에도 포함되어 있지 않으면 에러 리턴,
        List<Menu> menus = new ArrayList<>();
        menus.add(MainMenu);
        Menu menu = containsMenuItem(s,MainMenu.values());
        if (menu != null) return menu;

        menu = containsMenuItem(s,Appetizer.values());
        if (menu != null) return menu;

        menu = containsMenuItem(s,Drinks.values());
        if (menu != null) return menu;

        menu = containsMenuItem(s,Dessert.values());
        if (menu != null) return menu;

        throw new NoMenuException();

    }


    private static Menu containsMenuItem(String input, Menu[] menuItems){
        for(Menu menuItem : menuItems){
            if (menuItem.getMenuName().equals(input)){return menuItem;}
        }
        return null;
    }
}
