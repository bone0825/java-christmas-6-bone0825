package christmas.menu;

public enum Appetizer implements Menu{

    MUSHROOMSOUP("양송이수프",6000,"Appitizer"),
    TAPAS("타파스",5000,"Appitizer"),
    CAESARSALAD("시저샐러드",8000,"Appitizer");



    private String menuName;
    private int menuPrice;
    private String menuType;

    private Appetizer(String menuName, int menuPrice, String menuType) {
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
