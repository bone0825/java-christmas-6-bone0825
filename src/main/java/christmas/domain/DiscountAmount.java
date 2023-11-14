package christmas.domain;

public enum DiscountAmount {
    DAY_WEEKEND_DISCOUNT(2023),
    D_DAY_DISCOUNT(1000),
    D_DAY_DISCOUNT_PERDAY(100);

    private int discounts;

    private DiscountAmount(int discounts){
        this.discounts = discounts;
    }

    public int getDiscounts(){return discounts;}

}
