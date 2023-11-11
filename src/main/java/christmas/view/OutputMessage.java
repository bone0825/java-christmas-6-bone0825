package christmas.view;

public enum OutputMessage {
    SERVICE_OUTPUT_PROMOTIONS_PREVIEW("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDERED_MENU("<주문 메뉴>"),
    OUTPUT_GIVEAWAY_MENU("<증정 메뉴>"),
    OUTPUT_GIVEAWAY_BADGE("<증정 배지>"),
    OUTPUT_BENEFIT_DETAILS("<혜택 내역>"),
    OUTPUT_TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    OUTPUT_TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    OUTPUT_TOTAL_ORDER_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>");

    private final String value;

    OutputMessage(String value){
        this.value = value;
    }

    public String getMessage(){
        return value;
    }
}
