package christmas.utils;

import christmas.exception.inputvalidator.IllegalOrderException;
import christmas.exception.inputvalidator.NoMenuException;
import christmas.exception.inputvalidator.NonNumericInputException;
import christmas.exception.inputvalidator.ContainSpaceException;

import christmas.menu.*;
import com.sun.tools.javac.Main;


import java.util.List;


public class InputValidator {
    public static void validateAmountNotNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new NonNumericInputException();
        }
    }

    public static void validateContainSpace(String inputValue){
        if(inputValue.contains(" ")) throw new ContainSpaceException();
    }


    public static void validateMenuForm(String order) {
        if (!order.contains("-")) throw new IllegalOrderException();
        if (!order.contains(",")) throw new IllegalOrderException();
    }

    public static void validateMenuInput(String s) {
        if(!containsMenuItem(s, MainMenu.values())) throw new NoMenuException();
        if(!containsMenuItem(s, Appetizer.values())) throw new NoMenuException();
        if(!containsMenuItem(s, Dessert.values())) throw new NoMenuException();
        if(!containsMenuItem(s, Drinks.values())) throw new NoMenuException();

    }

    private static boolean containsMenuItem(String input, Menu[] menuItems){
        for(Menu menuItem : menuItems){
            if (menuItem.getMenuName().equals(input)){return true;}
        }
        return false;
    }
}
