package christmas.domain;

public enum GiveawayMenu {
    Champagne("샴페인",25000,120000);

    private String menuName;
    private int price;
    private int neededAmount;

    private GiveawayMenu(String menuName, int price,int neededAmount) {
        this.menuName=menuName;
        this.price=price;
        this.neededAmount=neededAmount;
    }

    public String getGivewawyMenuName(){return menuName;}
    public int getGivewawyMenuPrice(){return price;}
    public int getNeededAmount(){return neededAmount;}
}
