package christmas.controller;

import christmas.domain.OrderGenerator;
import christmas.domain.PromotionGenerator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasService {
    private InputView inputView;
    private OutputView outputView;
    private int reservationDay;

    PromotionGenerator promotionGenerator;


    public ChristmasService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        System.out.println(outputView.outputhelloMessage());
        reservationDay = inputView.inputDateToReserve();
    }

    public void run() {
        OrderGenerator orderGenerator = new OrderGenerator(inputView,outputView);
        promotionGenerator = new PromotionGenerator(reservationDay,orderGenerator.getOrderedMenus());
        showOrderedResult(promotionGenerator);
    }

    private void showOrderedResult(PromotionGenerator promotions) {
        System.out.println(outputView.showPromotionPreview(reservationDay));;
        showOrderedMenu();
        showTotalPrice();
        showGiveawayMenu();
        showBenefits();
        showTotalBenefits();
        showExpectedPayment();
        showEventBadge();
    }

    private void showEventBadge() {
        System.out.println();
        System.out.println(outputView.outputGiveawayBadge());
        System.out.println(promotionGenerator.getEventBadge());
    }

    private void showExpectedPayment() {
        System.out.println();
        System.out.println(outputView.outputExpectedPrice());
        System.out.println(promotionGenerator.getExpectedPayment());
    }

    private void showTotalBenefits() {
        System.out.println();
        System.out.println(outputView.outputTotalBenefits());
        System.out.println(promotionGenerator.getTotalBenefits());
    }

    private void showBenefits() {
        System.out.println();
        System.out.println(outputView.outputBenefitDetails());
        System.out.println(promotionGenerator.getBenefits());
    }

    private void showGiveawayMenu() {
        System.out.println();
        System.out.println(outputView.outputGiveawayMenus());
        System.out.println(promotionGenerator.getGiveawayMenu());

    }

    private void showTotalPrice() {
        System.out.println();
        System.out.println(outputView.outputTotalPrices());
        System.out.println(OutputView.outputPriceFormat(promotionGenerator.getTotalPrice())+"원");
    }

    private void showOrderedMenu() {
        System.out.println();
        System.out.println(outputView.outputOrderedMenu());
        System.out.println(promotionGenerator.getOrderedMenu());
    }


}
