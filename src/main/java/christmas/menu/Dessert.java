package christmas.menu;

public enum Dessert implements Menu {

    CHOCOCAKE("초코케이크","15,000",15000),
    ICECREAM("아이스크림","5,000",5000);

    private String menuName;
    private String menuPrice;
    private int menuValue;

    private Dessert(String menuName, String menuPrice, int menuValue){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuValue = menuValue;
    }

}
