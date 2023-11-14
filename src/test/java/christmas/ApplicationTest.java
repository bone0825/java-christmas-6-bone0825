package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    } //pass
    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    } //pass
    @Test
    void 증정_메뉴_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<증정 메뉴>" + LINE_SEPARATOR + "없음");
        });
    } //pass
    @Test
    void 이벤트_배지_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "없음");
        });
    } //pass
    @Test
    void 특별_할인_적용_출력(){
        assertSimpleTest(() -> {
            run("25", "타파스-1,제로콜라-1");
            assertThat(output()).contains("특별 할인: -1,000원");
        });
    } //pass
    @Test
    void 평일_할인_적용_출력(){
        assertSimpleTest(() -> {
            run("12", "초코케이크-1,제로콜라-1");
            assertThat(output()).contains("평일 할인: -2,023원");
        });
    } //pass
    @Test
    void 주말_할인_적용_출력(){
        assertSimpleTest(() -> {
            run("22", "티본스테이크-1,제로콜라-1");
            assertThat(output()).contains("주말 할인: -2,023원");
        });
    } //pass
    @Test
    void 디데이_할인_적용_출력(){
        assertSimpleTest(() -> {
            run("2", "타파스-1,제로콜라-1");
            assertThat(output()).contains("크리스마스 디데이 할인: -1,100원");
        });
    } //Pass
    @Test
    void 이벤트_배지_별_출력() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-2,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "별");
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
    void 이벤트_배지_산타_출력() {
        assertSimpleTest(() -> {
            run("25", "아이스크림-10,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "산타");
        });
    } //pass
    @Test
    void 증정_메뉴_출력() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-3,제로콜라-1");
            assertThat(output()).contains("샴페인 1개");
        });
    } //pass
    @Test
    void 총혜택_금액_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("<총혜택 금액>"+LINE_SEPARATOR+"-31,246원");
        });
    } //pass
    @Test
    void 할인_후_예상_결제_금액_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "135,754원");
        });
    } //pass

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    } //pass
    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    } //pass
    

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
