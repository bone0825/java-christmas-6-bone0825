package christmas.domain;

import christmas.menu.Menu;
import christmas.utils.StringUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class PromotionGenerator {

    private int reservationDay;
    private Map<Map<Menu,Integer>,Integer> orders; //<<카테고리,주문번호>,주문개수>
    private int totalPrice; //할인 전 총 금액

    InputView inputView;
    OutputView outputView;
    PromotionCalculator promotionCalculator;

    public PromotionGenerator(InputView inputView, OutputView outputView, int reservationDay,Map<Map<Menu,Integer>,Integer> orders){
        this.inputView = inputView;
        this.outputView = outputView;
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

    public void showOrderedMenu() {
        System.out.println();
        System.out.println(outputView.outputOrderedMenu());
        orders.forEach((menus,counts)->{
            menus.forEach((menu,number)->{
                System.out.println(menu.getMenus(number)+ " " + counts+"개");
            });
        });
    }

    public void showTotalPrice() {
        System.out.println();
        System.out.println(outputView.outputTotalPrices());
        System.out.println(OutputView.outputPriceFormat(totalPrice)+"원");
    }

    public void showGiveawayMenu() {
        System.out.println();
        System.out.println(outputView.outputGiveawayMenus());
        System.out.println(promotionCalculator.showGiveawayMenu());
    }

    public void showBenefits() {
        System.out.println();
        System.out.println(outputView.outputBenefitDetails());
        List<String> details =  promotionCalculator.showBenefitDetails();
        if (details.isEmpty())  {System.out.println(OutputView.outputNothing());}
        if (!details.isEmpty()){
            for(String detail :details){
                System.out.println(detail);
            }
        }
    }

    public void showTotalBenefits() {
        System.out.println();
        System.out.println(outputView.outputTotalBenefits());
        promotionCalculator.showTotalBenefit();
    }

    public void showExpectedPayment() {
        System.out.println();
        System.out.println(outputView.outputExpectedPrice());
        promotionCalculator.showExpectedPrice();
    }

    public void showEventBadge() {
        System.out.println();
        System.out.println(outputView.outputGiveawayBadge());
        System.out.println(promotionCalculator.showGiveawayBadge());
    }
}
