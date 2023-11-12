package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.Menu;
import christmas.utils.InputValidator;

import java.util.List;
import java.util.Map;

import static christmas.utils.StringUtil.stringToInt;

import static christmas.view.InputMessage.*;

public class InputView {

    public int inputDateToReserve(){ //예약 날자 입력
        System.out.println(SERVICE_INPUT_DAYS.getMessage());
        try{
            return stringToInt(Console.readLine());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputDateToReserve();
        }
    }

    public String inputOrderMenu(){ //주문 메뉴 입력
        System.out.println(SERVICE_INPUT_MENUS.getMessage());
        try{
            String userInput = Console.readLine();

            return userInput;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputOrderMenu();
        }

    }
}
