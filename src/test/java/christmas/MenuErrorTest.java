package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.utils.MenuValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.utils.StringUtil.stringToMap;
import static org.assertj.core.api.Assertions.*;

public class MenuErrorTest extends NsTest {

    @ValueSource(strings = {"제로콜라-1","제로콜라-2,샴페인-1"})
    @ParameterizedTest
    void 음료만_주문_예외_테스트(String inputValue){
        assertThatThrownBy(() ->MenuValidator.validateMenuOnlyDrinks(stringToMap(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문할 수 없습니다.");
    } //pass
    @ValueSource(strings = {"티본스테이크-3,제로콜라-1,제로콜라-2","티본스테이크-1,타파스-1,타파스-1"})
    @ParameterizedTest
    void 중복_주문_예외_테스트(String inputValue){
        assertThatThrownBy(() ->MenuValidator.validateMenuOnlyDrinks(stringToMap(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    } //pass

    @ValueSource(strings = {"타파스-11,제로콜라-10","타파스-22"})
    @ParameterizedTest
    void 전체_주문_개수_20개_이상_예외_테스트(String inputValue){
        assertThatThrownBy(() -> stringToMap(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 주문 메뉴 개수는 20개를 넘길 수 없습니다. 다시 입력해 주세요");
    } //pass

    @Test
    void 주문_개수_0개_이하_예외_테스트(){
        assertSimpleTest(() -> {
            runException("3", "제로콜라-1,타파스-0");
            assertThat(output()).contains("[ERROR] 메뉴의 개수는 0 이하일 수 없습니다.");
        });
    } //pass

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
