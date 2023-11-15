package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.PromotionCalculator;
import christmas.menu.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    PromotionCalculator promotionCalculator;

    @Test
    void 특별_할인_적용(){
        setEvent();
        printEvents("특별 할인: -1,000원");
    }//pass
    @Test
    void 디데이_할인_적용(){
        setEvent();
        printEvents("크리스마스 디데이 할인: -3,400원");
    }//pass
    @Test
    void 평일_할인_적용(){
        setEvent();
        printEvents("평일 할인: -4,046원");
    }//pass
    @Test
    void 총혜택_적용(){
        setEvent();
        assertSimpleTest(() -> {
            assertThat(promotionCalculator.showTotalBenefit()).contains("-8,446원");
        });
    }//pass
    @Test
    void 예상_금액(){
        setEvent();
        assertSimpleTest(() -> {
            assertThat(promotionCalculator.showExpectedPrice()).contains("24,554원");
        });
    }//pass
    @Test
    void 별배지_적용(){
        setEvent();
        assertSimpleTest(() -> {
            assertThat(promotionCalculator.showGiveawayBadge()).contains("별");
        });
    }//pass

    void setEvent(){
        Map<Map<Menu, Integer>, Integer> menus = new HashMap<>();

        // DESSERT에 대한 값을 갖는 menu Map을 생성하고 이를 menus Map에 추가합니다.
        Map<Menu, Integer> dessertMap = new HashMap<>();
        dessertMap.put(Menu.DESSERT, 1);
        menus.put(dessertMap, 2);

        // DRINKS에 대한 값을 갖는 menu Map을 생성하고 이를 menus Map에 추가합니다.
        Map<Menu, Integer> drinksMap = new HashMap<>();
        drinksMap.put(Menu.DRINKS, 1);
        menus.put(drinksMap, 1);
        promotionCalculator = new PromotionCalculator(25,33000,menus);
    }
    void printEvents(String result){
        assertSimpleTest(() -> {
            assertThat(promotionCalculator.showBenefitDetails()).contains(result);
        });
    }
    @Test
    void 이벤트_혜택_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<증정 메뉴>" + LINE_SEPARATOR + "없음",
                    "<혜택 내역>" + LINE_SEPARATOR + "없음",
                    "<총혜택 금액>" + LINE_SEPARATOR + "0원",
                    "<12월 이벤트 배지>" + LINE_SEPARATOR + "없음");
        });
    } //pass

    @Test
    void 주말_할인_적용_출력(){

//        assertThat(promotionGenerator.getOrderedMenu()).contains(2,023원);
        assertSimpleTest(() -> {
            run("30", "티본스테이크-1,제로콜라-1");
            assertThat(output()).contains("주말 할인: -");
        });
    } //pass
    @Test
    void 이벤트_배지_트리_출력() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-5,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "트리");
        });
    } //pass
    @Test
    void 산타배지_증정_메뉴_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-3,제로콜라-1");
            assertThat(output()).contains("샴페인 1개","산타");
        });
    } //pass

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
