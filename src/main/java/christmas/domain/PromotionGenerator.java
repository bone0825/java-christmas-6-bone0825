package christmas.domain;

import christmas.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionGenerator {
    private int reserveDay; // 예약시간
    private Map<Menu,Integer> menus; //메뉴 , 주문개수
    private List<Map<Menu,Integer>> menuCategory; //카테고리 별 메뉴
    private List<List<Map<Menu,Integer>>> totalMenus = new ArrayList<>(); //전체 카테고리 포함 메뉴
    private int totalPrice; //할인 전 총 금액



    public PromotionGenerator(int reserveDay, Map<Menu, Integer> menus){
        this.reserveDay=reserveDay;
        this.menus = menus;
        promotionGenerate();
    }

    private void promotionGenerate() {
        int totalPrice = getTotalPrice(menus);

    }

    private int getTotalPrice(Map<Menu, Integer> menus) {

        return 0;
    }
}
