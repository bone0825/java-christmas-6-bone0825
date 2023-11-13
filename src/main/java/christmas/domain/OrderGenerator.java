package christmas.domain;

import christmas.menu.Menu;
import christmas.utils.MenuValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

import static christmas.utils.StringUtil.stringToMap;

public class OrderGenerator {
    private InputView inputView;
    private OutputView outputView;
    private Map<Map<Menu,Integer>,Integer> orders; //메뉴 , 주문개수
    public OrderGenerator(InputView inputView,OutputView outputView){
        this.outputView = outputView;
        this.inputView = inputView;
        showAllMenus();
        this.orders= makeOrders(); //주문 내역 생성
    }
    private void showAllMenus() {
        System.out.println();
        System.out.println(outputView.outputOrderableMenus());
        System.out.println();
        for(Menu menu : Menu.values()){
            System.out.println(menu.getType() + " : " + String.join(",",menu.getAllMenus()));
        }
    }

    private Map<Map<Menu,Integer>, Integer> makeOrders() {
        Map<Map<Menu,Integer>, Integer> orders;
        String menuInput = inputView.inputOrderMenu();
        try{
            orders = stringToMap(menuInput);
            MenuValidator.validateMenuOnlyDrinks(orders);
            return orders;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return makeOrders();
        }
    }

    public Map<Map<Menu,Integer>, Integer> getOrderedMenus(){ return orders;}
}
