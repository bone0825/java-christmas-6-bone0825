package christmas.domain;

public enum GiveawayMenu {
    Champagne("샴페인",25000);

    private String menuName;
    private int price;

    private GiveawayMenu(String menuName, int price) {
        this.menuName=menuName;
        this.price=price;
    }

    public String getGivewawyMenuName(){return menuName;}
    public int getGivewawyMenuPrice(){return price;}

}
