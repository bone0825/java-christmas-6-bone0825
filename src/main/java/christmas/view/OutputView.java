package christmas.view;

import java.text.DecimalFormat;

import static christmas.view.OutputMessage.*;

public class OutputView {

    private static final String OUTPUT_PRICE_FORMAT = "#,###.#";

    public static String outputPriceFormat (int price){
        DecimalFormat format = new DecimalFormat(OUTPUT_PRICE_FORMAT);
        return format.format(price);
    }

    public String outputhelloMessage(){
        return OUTPUT_SERVICE_HELLO.getMessage();
    }

    public String outputOrderableMenus() {
        return OUTPUT_ALL_MENULS.getMessage();
    }

    public String showPromotionPreview(int reservationDay){ return String.format(SERVICE_OUTPUT_PROMOTIONS_PREVIEW.getMessage(),reservationDay);}

    public String outputOrderedMenu(){return OUTPUT_ORDERED_MENU.getMessage();}
    public String outputTotalPrices() {return OUTPUT_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage();}
    public String outputGiveawayMenus() {return OUTPUT_GIVEAWAY_MENU.getMessage();}
    public String outputBenefitDetails() {return OUTPUT_BENEFIT_DETAILS.getMessage();}
    public String outputTotalBenefits(){return OUTPUT_TOTAL_BENEFIT_AMOUNT.getMessage();}
    public String outputExpectedPrice(){return OUTPUT_TOTAL_ORDER_AMOUNT_AFTER_DISCOUNT.getMessage();}
    public String outputGiveawayBadge(){return OUTPUT_GIVEAWAY_BADGE.getMessage();}
    public static String outputNothing() {return OUTPUT_NOTHING.getMessage();}


}
