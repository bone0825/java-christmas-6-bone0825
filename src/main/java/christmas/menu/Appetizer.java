package christmas.menu;

public enum Appetizer implements Menu{

    MUSHROOMSOUP("양송이수프","6,000",6000),
    TAPAS("타파스","5,500",5000),
    CAESARSALAD("시저샐러드","8,000",8000);



    private String menuName;
    private String menuPrice;
    private int menuValue;

    private Appetizer(String menuName, String menuPrice, int menuValue){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuValue = menuValue;
    }

}
