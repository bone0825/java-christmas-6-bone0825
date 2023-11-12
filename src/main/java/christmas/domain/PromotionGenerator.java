package christmas.domain;

import static christmas.utils.StringUtil.stringToMap;

import christmas.menu.Menu;
import christmas.utils.StringUtil;
import christmas.view.InputView;

import java.util.Map;

public class PromotionGenerator {

    private int reservationDay;
    private Map<Map<Menu,Integer>,Integer> orders; //<<카테고리,주문번호>,주문개수>
    private int totalPrice; //할인 전 총 금액

    InputView inputView;

    public PromotionGenerator(InputView inputView, int reservationDay,Map<Map<Menu,Integer>,Integer> orders){
        this.inputView = inputView;
        this.reservationDay = reservationDay;
        this.orders= orders; //주문 내역 생성
        setTotalPrice(orders);
        System.out.println(totalPrice);
    }

    private void setTotalPrice(Map<Map<Menu, Integer>, Integer> orders) {
        orders.forEach((menus,counts) ->{
            menus.forEach((menu,number)->{
                 totalPrice += menu.getPrices(number)*counts;
            });
        });

    }



}
