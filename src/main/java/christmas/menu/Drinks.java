package christmas.menu;

public enum Drinks implements Menu {
    ZEROCOKE("제로콜라", 3000),
    REDWINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000);


    private String menuName;
    private int menuPrice;

    private Drinks(String menuName, int menuPrice) {
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

