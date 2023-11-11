package christmas.utils;

import java.util.*;

public class StringUtil {

    public static int stringToInt(String inputValue) {
        InputValidator.validateAmountNotNumber(inputValue); //유효성 검사 불통시 NonNumericInputException()
        return Integer.parseInt(inputValue);
    }

    public static Map<String, Integer> stringToMap(String inputValue){//공백 없음, ","로 잘 나눠졌는지 체크 후 실행
        InputValidator.validateContainSpace(inputValue);//공백 체크
        InputValidator.validateMenuForm(inputValue);//"," "-"로 잘 나눠져 있나 체크
        List<String> orders = splitMenus(inputValue);
        return listToMap(orders);
    }

    private static Map<String, Integer> listToMap(List<String> orders) {
        Map<String,Integer> menuAndCounts = new HashMap<>();
        for(String order :orders){
            String[] menuAndCount = order.split("-");
            InputValidator.validateMenuInput(menuAndCount[0]);//입력된 메뉴가 존재하는가
            InputValidator.validateAmountNotNumber(menuAndCount[1]);//개수가 정상적으로 입력되었나
            menuAndCounts.put(menuAndCount[0],Integer.parseInt(menuAndCount[1]));
        }
        return menuAndCounts;


    }

    private static List<String> splitMenus(String inputValue){
        return Arrays.asList(inputValue.split(","));
    }
}
