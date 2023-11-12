package christmas.menu;

public enum Drinks implements Menu {
    ZEROCOKE("제로콜라", 3000,"Drinks"),
    REDWINE("레드와인",60000,"Drinks"),
    CHAMPAGNE("샴페인",25000,"Drinks");


    private String menuName;
    private int menuPrice;
    private String menuType;

    private Drinks(String menuName, int menuPrice, String menuType) {
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

