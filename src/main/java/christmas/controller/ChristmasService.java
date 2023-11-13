package christmas.controller;

import christmas.domain.OrderGenerator;
import christmas.domain.PromotionGenerator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasService {
    private InputView inputView;
    private OutputView outputView;
    private int reservationDay;


    public ChristmasService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        System.out.println(outputView.outputhelloMessage());
        reservationDay = inputView.inputDateToReserve();
    }

    public void run() {
        OrderGenerator orderGenerator = new OrderGenerator(inputView,outputView);
        PromotionGenerator promotions = new PromotionGenerator(inputView,outputView,reservationDay,orderGenerator.getOrderedMenus());
        showOrderedResult(promotions);
    }

    private void showOrderedResult(PromotionGenerator promotions) {
        System.out.println(outputView.showPromotionPreview(reservationDay));;
        promotions.showOrderedMenu();
        promotions.showTotalPrice();
        promotions.showGiveawayMenu();
        promotions.showBenefits();
        promotions.showTotalBenefits();
        promotions.showExpectedPayment();
        promotions.showEventBadge();
    }


}
