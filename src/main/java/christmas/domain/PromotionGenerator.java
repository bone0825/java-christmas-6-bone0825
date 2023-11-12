package christmas.domain;

import static christmas.utils.StringUtil.stringToMap;

import christmas.menu.Menu;
import christmas.utils.StringUtil;
import christmas.view.InputView;

import java.util.Map;

public class PromotionGenerator {

    private int reserveDay;
    private Map<Map<Menu,Integer>,Integer> orders; //<<카테고리,주문번호>,주문개수>
    private int totalPrice; //할인 전 총 금액

    InputView inputView;

    public PromotionGenerator(InputView inputView, int reserveDay,Map<Map<Menu,Integer>,Integer> orders){
        this.inputView = inputView;
        this.reserveDay = reserveDay; //예약 날짜 생성
        ;
        this.orders= orders; //주문 내역 생성
    }


}
