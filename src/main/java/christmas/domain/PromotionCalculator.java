package christmas.domain;

import christmas.menu.Menu;
import christmas.view.OutputView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionCalculator {

    private static final int YEAR = 2023; //삼페인 증정 금액
    private static final int DAYDISCOUNT = 2023; //주중, 주말 할인 금액
    private static final int MONTH = 12; //삼페인 증정 금액

    private static final int GIVEAWAYEVENTCHAMPAGNE = 120000; //삼페인 증정 금액

    private static final int CHRISTAMSDDAYDISCOUNTENDDAY = 25; // 크리스마스 디데이 할인 끝나는 날
    private static final int CHRISTAMSDDAYDISCOUNTPRICEDISCOUNT = 1000; // 크리스마스 디데이 할인 기본 금액
    private static final int CHRISTAMSDDAYDISCOUNTPRICEPERDAYDISCOUNT = 100; //크리스마스 디데이 할인 날짜별 추가금액



    private int reservationDay;
    private LocalDate visitDate;
    private int totalPrice;
    private Map<String, Integer> benefitDetails;
    private EvenetBadge evenetBadge;
    private int giveawayMenuDiscount;

    private int totalBenefits;
    private int mainMenuCount;
    private int DessertCount;
    private GiveawayMenu giveawayMenu;

    private boolean checkWeekend;
    private boolean checkSpeiclaDay;

    public PromotionCalculator(int reservationDay, int totalPrice, Map<Map<Menu, Integer>, Integer> orders){
        benefitDetails = new HashMap<>();
        this.visitDate = LocalDate.of(YEAR,MONTH,reservationDay);
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        this.reservationDay=reservationDay;
        this.totalPrice = totalPrice;
        this.giveawayMenu = checkGivewawyMenu();
        this.checkWeekend=checkWeekend(dayOfWeek);
        this.checkSpeiclaDay = checkSpecialDay(dayOfWeek);
        setTotalBenefits(orders);
        this.evenetBadge = checkEventBadge();
    }

    private boolean checkSpecialDay(DayOfWeek dayOfWeek) {
        int dayOfWeekNumber = dayOfWeek.getValue();
        if (dayOfWeekNumber == 7 || reservationDay == 25) return true;
        return false;
    }

    private boolean checkWeekend(DayOfWeek dayOfWeek) {
        int dayOfWeekNumber = dayOfWeek.getValue();
        if (dayOfWeekNumber == 6 || dayOfWeekNumber == 5) return true;
        return false;
    }


    private void setTotalBenefits(Map<Map<Menu, Integer>, Integer> orders){
        totalBenefits =0;
        int christmasDDayDiscount = christmasDDayDiscount();
        int weekdayDiscount = weekdayDiscount(orders);
        int weekendDiscount = weekendDiscount(orders);
        int specialDiscount = specialDiscount();
        giveawayMenuDiscount = giveawayMenuDiscount();
        totalBenefits = christmasDDayDiscount+weekdayDiscount+weekendDiscount+specialDiscount+giveawayMenuDiscount;
        makeBenefitDetails(christmasDDayDiscount,weekdayDiscount,weekendDiscount,specialDiscount,giveawayMenuDiscount);
    }

    private int specialDiscount() {
        if (checkSpeiclaDay) return 1000;
        return 0;
    }

    private void makeBenefitDetails(int christmasDDayDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount,int giveawayMenuDiscount ){
        benefitDetails.put("크리스마스 디데이 할인", christmasDDayDiscount);
        benefitDetails.put("평일 할인", weekdayDiscount);
        benefitDetails.put("주말 할인", weekendDiscount);
        benefitDetails.put("특별 할인", specialDiscount);
        benefitDetails.put("증정 이벤트", giveawayMenuDiscount);
    }

    private GiveawayMenu checkGivewawyMenu() {
        if (totalPrice > GIVEAWAYEVENTCHAMPAGNE) return GiveawayMenu.Champagne;
        return null;
    }

    private int giveawayMenuDiscount() {
        if (giveawayMenu!=null) return giveawayMenu.getGivewawyMenuPrice();
        return 0;
    }

    private int weekendDiscount(Map<Map<Menu, Integer>, Integer> orders) {
        if (checkWeekend) return checkMainMenuCount(orders) * DAYDISCOUNT;

        return 0;
    }

    private int checkMainMenuCount(Map<Map<Menu, Integer>, Integer> orders) {
        orders.forEach((menus,counts)->{
            menus.forEach((menu,number)->{
                mainMenuCount += getMainMenu(menu) * counts;
            });
        });
        return mainMenuCount;
    }

    private int getMainMenu(Menu menu) {
        if (menu.getType().equals("MainMenu")) return 1;
        return 0;
    }
    private int weekdayDiscount(Map<Map<Menu, Integer>, Integer> orders) {
        if (!checkWeekend) return checkDessertCount(orders) * DAYDISCOUNT;
        return 0;
    }

    private int checkDessertCount(Map<Map<Menu, Integer>, Integer> orders) {
        orders.forEach((menus,counts)->{
            menus.forEach((menu,number)->{
                DessertCount += getDessert(menu) * counts;
            });
        });
        return DessertCount;
    }

    private int getDessert(Menu menu) {
        if (menu.getType().equals("Dessert")) return 1;
        return 0;
    }

    private int christmasDDayDiscount() {
        if (reservationDay < CHRISTAMSDDAYDISCOUNTENDDAY) return CHRISTAMSDDAYDISCOUNTPRICEDISCOUNT+(reservationDay-1)*CHRISTAMSDDAYDISCOUNTPRICEPERDAYDISCOUNT;
        return 0;
    }


    public EvenetBadge checkEventBadge(){
        for(EvenetBadge evenetBadge : EvenetBadge.values()){
            if(totalBenefits>evenetBadge.getMinimumBenefit()) return evenetBadge;
        }
        return null;
    }

    public String showGiveawayMenu() {
        if(giveawayMenu != null) return giveawayMenu.getGivewawyMenuName() + " 1개";
        return OutputView.outputNothing();
    }

    public List<String> showBenefitDetails() {
        List<String> benefitDetials = new ArrayList<>();
        benefitDetails.forEach((benefits, amaount)->{
            if(amaount!=0) benefitDetials.add(benefits + ": -" + OutputView.outputPriceFormat(amaount) + "원");
        });
        return benefitDetials;
    }

    public void showTotalBenefit() {
        System.out.println("-"+ OutputView.outputPriceFormat(totalBenefits)+"원");
    }

    public void showExpectedPrice() {
        System.out.println(OutputView.outputPriceFormat(totalPrice - totalBenefits + giveawayMenuDiscount) + "원");
    }

    public String showGiveawayBadge() {
        if (evenetBadge!= null)return evenetBadge.getBadge();
        return OutputView.outputNothing();
    }
}
