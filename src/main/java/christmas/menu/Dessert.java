package christmas.menu;

public enum Dessert implements Menu {

    CHOCOCAKE("초코케이크",15000),
    ICECREAM("아이스크림",5000);

    private String menuName;
    private int menuPrice;

    private Dessert(String menuName, int menuPrice) {
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
