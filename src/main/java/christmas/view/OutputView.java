package christmas.view;

import java.text.DecimalFormat;

import static christmas.view.OutputMessage.*;

public class OutputView {
    private static final String OUTPUT_PRICE_FORMAT = "#,###.#";

    private static String outputPriceFormat (int price){
        DecimalFormat format = new DecimalFormat(OUTPUT_PRICE_FORMAT);
        return format.format(price);
    }

}
