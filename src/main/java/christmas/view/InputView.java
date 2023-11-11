package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputValidator;

import java.util.Map;

import static christmas.utils.StringUtil.stringToInt;
import static christmas.utils.StringUtil.stringToMap;

import static christmas.view.InputMessage.*;

public class InputView {

    public int inputDateToReserve(){
        System.out.println(SERVICE_INPUT_DAYS.getMessage());
        try{
            return stringToInt(Console.readLine());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputDateToReserve();
        }
    }

    public Map<String,Integer> inputOrderMenu(){
        System.out.println(SERVICE_INPUT_MENUS.getMessage());
        try{
            return stringToMap(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputOrderMenu();
        }

    }
}
