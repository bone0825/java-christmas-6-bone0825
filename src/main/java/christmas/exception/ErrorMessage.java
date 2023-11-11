package christmas.exception;

public enum ErrorMessage {

    NONNUMERICINPUT("[ERROR] 잘못된 양식입니다. 정확한 숫자를 입력해 주세요."),
    NONSPACEINPUT("[ERROR] 공백 없이 입력해 주세요"),
    ILLEGALORDERINPUT("[ERROR] 잘못된 주문 입력입니다. 주문 양식을 준수해 주세요."),
    MENUNOTEXIST("[ERROR] 존재하지 않는 메뉴입니다. 주문 양식을 준수해 주세요"),
    ;

    private final String value;

    ErrorMessage(String value){
        this.value = value;
    }

    public String getMessage(){
        return value;
    }
}
