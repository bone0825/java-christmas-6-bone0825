package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

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
    void 특별_디데이_평일_할인_할인후예상_별배지_적용_출력(){
        assertSimpleTest(() -> {
            run("25", "초코케이크-2,제로콜라-1");
            assertThat(output()).contains("특별 할인: -1,000원",
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -4,046원",
                    "<총혜택 금액>" + LINE_SEPARATOR + "-8,446원",
                    "<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "24,554원",
                    "<12월 이벤트 배지>" + LINE_SEPARATOR + "별");
        });
    } //pass
    @Test
    void 주말_할인_적용_출력(){
        assertSimpleTest(() -> {
            run("30", "티본스테이크-1,제로콜라-1");
            assertThat(output()).contains("주말 할인: -2,023원");
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
