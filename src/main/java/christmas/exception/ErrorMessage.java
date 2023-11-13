package christmas.exception;

public enum ErrorMessage {
    EMPTYORDEREXCEPTION("[ERROR] 주문에는 공백이 들어갈 수 없습니다. 양식읃 다시 확인해 주세요."),
    ONLYDRINKSEXCEPTION("[ERROR] 음료만 주문할 수 없습니다."),
    ILLEGALDAYEXCEPTION("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NONNUMERICINPUT("[ERROR] 잘못된 양식입니다. 정확한 숫자를 입력해 주세요."),
    NONSPACEINPUT("[ERROR] 공백 없이 입력해 주세요"),
    ILLEGALORDERINPUT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENUNOTEXIST("[ERROR] 존재하지 않는 메뉴입니다. 주문 양식을 준수해 주세요"),
    MENUCOUNTOUTOFRANGE("[ERROR] 주문 메뉴 개수는 20개를 넘길 수 없습니다. 다시 입력해 주세요")
    ;

    private final String value;

    ErrorMessage(String value){
        this.value = value;
    }

    public String getMessage(){
        return value;
    }
}
