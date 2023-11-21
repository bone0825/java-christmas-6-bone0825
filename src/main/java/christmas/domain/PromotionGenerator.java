package christmas.domain;

import christmas.menu.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class PromotionGenerator {

    private int reservationDay;
    private Map<Map<Menu,Integer>,Integer> orders; //<<카테고리,주문번호>,주문개수>
    private int totalPrice; //할인 전 총 금액

    PromotionCalculator promotionCalculator;

    public PromotionGenerator(int reservationDay,Map<Map<Menu,Integer>,Integer> orders){

        this.reservationDay = reservationDay;
        this.orders= orders; //주문 내역 생성
        setTotalPrice(orders);
        promotionCalculator = new PromotionCalculator(reservationDay,totalPrice,orders);
    }

    private void setTotalPrice(Map<Map<Menu, Integer>, Integer> orders) {
        orders.forEach((menus,counts) ->{
            menus.forEach((menu,number)->{
                 totalPrice += menu.getPrices(number)*counts;
            });
        });
    }

    public String getOrderedMenu() {
        StringBuilder orderMenus = new StringBuilder();
        orders.forEach((menus,counts)->{
            menus.forEach((menu,number)->{
                orderMenus.append(menu.getMenus(number)).append(" ").append (counts).append("개\n");
            });
        });
        return orderMenus.toString();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getGiveawayMenu() {
        return promotionCalculator.showGiveawayMenu();
    }

    public String getBenefits() {
        List<String> details =  promotionCalculator.showBenefitDetails();
        StringBuilder benefits = new StringBuilder();
        if (details.isEmpty())  {return OutputView.outputNothing();}
        for(String detail :details){benefits.append(detail).append("\n");}

        return benefits.toString();
    }

    public String getTotalBenefits() {
        return promotionCalculator.showTotalBenefit();
    }

    public String getExpectedPayment() {
        return promotionCalculator.showExpectedPrice();
    }

    public String getEventBadge() {
        return promotionCalculator.showGiveawayBadge();
    }
}
