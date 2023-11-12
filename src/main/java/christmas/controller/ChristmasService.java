package christmas.controller;

import christmas.domain.OrderGenerator;
import christmas.domain.PromotionGenerator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasService {
    InputView inputView;
    OutputView outputView;

    public ChristmasService(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        System.out.println(outputView.helloMessage());
        int reservationDay = inputView.inputDateToReserve();
        OrderGenerator orderGenerator = new OrderGenerator(inputView,outputView);
        PromotionGenerator promotions = new PromotionGenerator(inputView,reservationDay,orderGenerator.getOrderedMenus());
    }


}
