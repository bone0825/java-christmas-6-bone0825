package domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.EvenetBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest extends NsTest {
    @DisplayName("getBadgeTest")
    @Test
    void getBadgeTest() {
        assertSimpleTest(() ->{
            for(EvenetBadge evenetBadge : EvenetBadge.values()) System.out.println(evenetBadge.getBadge());
            assertThat(output()).contains("산타","트리","별");
        });
    }

    @DisplayName("getMinimumBenefitTest")
    @Test
    void getMinimumBenefitTest() {
        assertSimpleTest(() ->{
            for(EvenetBadge evenetBadge : EvenetBadge.values()) System.out.println(evenetBadge.getMinimumBenefit());
            assertThat(output()).contains("20000","10000","5000");
        });
    }

    @Override
    protected void runMain() {}
}
