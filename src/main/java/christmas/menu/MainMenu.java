package christmas.menu;

public enum MainMenu implements Menu {
    TBORNSTAEK("티본스테이크",55000),
    BBQRIBS("바베큐립",54000),
    SEAFOODSPAGHETTI("해산물파스타",35000),
    CHRISTMASSPAGHETTI("크리스마스파스타",25000);

    private String menuName;
    private int menuPrice;

    private MainMenu(String menuName, int menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public int getMenuPrice() {
        return menuPrice;
    }
}
