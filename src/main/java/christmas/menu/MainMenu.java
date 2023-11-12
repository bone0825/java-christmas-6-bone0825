package christmas.menu;

public enum MainMenu implements Menu {
    TBORNSTAEK("티본스테이크",55000,"MainMenu"),
    BBQRIBS("바베큐립",54000,"MainMenu"),
    SEAFOODSPAGHETTI("해산물파스타",35000,"MainMenu"),
    CHRISTMASSPAGHETTI("크리스마스파스타",25000,"MainMenu");

    private String menuName;
    private int menuPrice;
    private String menuType;

    private MainMenu(String menuName, int menuPrice, String menuType) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public int getMenuPrice() {
        return menuPrice;
    }

    @Override
    public String getType() { return menuType; }
}
