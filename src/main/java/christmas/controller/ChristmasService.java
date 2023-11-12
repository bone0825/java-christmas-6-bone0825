package christmas.controller;

import christmas.domain.PromotionGenerator;
import christmas.menu.Menu;
import christmas.utils.InputValidator;
import christmas.view.InputView;

import java.util.*;

public class ChristmasService {
    InputView inputview = new InputView();
    public void run() {
        int reseveDay = inputview.inputDateToReserve();
        String menus = inputview.inputOrderMenu();
        PromotionGenerator promotions = new PromotionGenerator(reseveDay,menus);
    }

    public static List<List<Map>> stringToLists(String inputValue){
        InputValidator.validateContainSpace(inputValue);//공백 체크
        InputValidator.validateMenuForm(inputValue);//"," "-"로 나눠져 있나 체크
        List<String> orders = splitMenus(inputValue);
        return listToMap(orders);
    }

    private static Map<String, Integer> listToMap(List<String> orders) {
        Map<Menu,Integer> menuAndCounts = new HashMap<>();
        Menu inputMenus;
        for(String order :orders){
            String[] menuAndCount = order.split("-");
            InputValidator.validateMenuInput(menuAndCount[0]);//입력된 메뉴가 존재하는가
            InputValidator.validateAmountNotNumber(menuAndCount[1]);//개수가 정상적으로 입력되었나
        }
        return menuAndCounts;


    }
    public Menu getMenuItem(String input, Menu[] menuItems) {
        for (Menu menuItem : menuItems) {
            if (menuItem.getMenuName().equals(input)) {
                return menuItem;
            }
        }
        return null;
    }


    private static List<String> splitMenus(String inputValue){
        return Arrays.asList(inputValue.split(","));
    }


}
