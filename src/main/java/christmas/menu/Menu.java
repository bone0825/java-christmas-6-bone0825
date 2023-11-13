package christmas.menu;

import java.util.Arrays;
import java.util.List;

public enum Menu{

    MAINMENU("MainMenu", Arrays.asList("티본스테이크","바비큐립","해산물파스타","크리스마스파스타"),Arrays.asList(55000,54000,35000,25000)),
    APPITIZER("Appitizer", Arrays.asList("양송이수프","타파스","시저샐러드"),Arrays.asList(6000,5000,8000)),
    DESSERT("Dessert", Arrays.asList("초코케이크","아이스크림"), Arrays.asList(15000,5000)),
    DRINKS("Drinks", Arrays.asList("제로콜라","레드와인","샴페인"), Arrays.asList(3000,60000,25000));


    private String menuType;
    private List<String> menus;
    private List<Integer> prices;

    private Menu(String menuType, List<String> menus, List<Integer> prices) {
        this.menuType = menuType;
        this.menus = menus;
        this.prices = prices;
    }

    public String getType() { return menuType; }

    public List<String> getAllMenus() { return menus; }
    public List<Integer> getPrices() { return prices;}

    public int getPrices(int i){ return prices.get(i);}
    public String getMenus(int i){ return menus.get(i);}

}
