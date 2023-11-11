package christmas.menu;

public enum MainMenu implements Menu {
    TBORNSTAEK("티본스테이크","55,000",55000),
    BBQRIBS("바베큐립","54,000",54000),
    SEAFOODSPAGHETTI("해산물파스타","35,000",35000),
    CHRISTMASSPAGHETTI("크리스마스파스타","25,000",25000);



    private String menuName;
    private String menuPrice;
    private int menuValue;

    private MainMenu(String menuName, String menuPrice, int menuValue){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuValue = menuValue;
    }

    @Override
    public String getMenuName() {
        return null;
    }

    @Override
    public String getMenuPrice() {
        return null;
    }

    @Override
    public int getMenuValue() {
        return menuValue;
    }
}
