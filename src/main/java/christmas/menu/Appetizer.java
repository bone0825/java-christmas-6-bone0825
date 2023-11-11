package christmas.menu;

public enum Appetizer implements Menu{

    MUSHROOMSOUP("양송이수프",6000),
    TAPAS("타파스",5000),
    CAESARSALAD("시저샐러드",8000);



    private String menuName;
    private int menuPrice;

    private Appetizer(String menuName, int menuPrice) {
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
