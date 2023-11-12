package christmas.menu;

public enum Dessert implements Menu {

    CHOCOCAKE("초코케이크",15000,"Dessert"),
    ICECREAM("아이스크림",5000,"Dessert");

    private String menuName;
    private int menuPrice;
    private String menuType;

    private Dessert(String menuName, int menuPrice, String menuType) {
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
