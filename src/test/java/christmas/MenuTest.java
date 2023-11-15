package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.OrderGenerator;
import christmas.domain.PromotionGenerator;
import christmas.menu.Menu;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    Map<Menu, Integer> menu = new HashMap<>();
    Map<Map<Menu,Integer>, Integer> menus = new HashMap<>();

    @Test
    void 특별_할인_적용(){
        printEvents("특별 할인: -1,000원");
    }//pass
    @Test
    void 디데이_할인_적용(){
        printEvents("크리스마스 디데이 할인: -3,400원");
    }//pass
    @Test
    void 평일_할인_적용(){
        printEvents("평일 할인: -4,046원");
    }//pass
    @Test
    void 총혜택_적용(){
        printEvents("<총혜택 금액>" + LINE_SEPARATOR + "-8,446원");
    }//pass
    @Test
    void 예상_금액(){
        printEvents("<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "24,554원");
    }//pass
    @Test
    void 별배지_적용(){
        printEvents("<12월 이벤트 배지>" + LINE_SEPARATOR + "별");
    }//pass

    void printEvents(String output){
//        OrderGenerator orderGenerator = new OrderGenerator();
        menu.put(Menu.DESSERT,1);g
        menu.put(Menu.DRINKS,1);

        assertSimpleTest(() -> {
            run("25", "초코케이크-2,제로콜라-1");
            assertThat(output()).contains(output);
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
