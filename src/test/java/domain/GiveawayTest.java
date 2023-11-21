package domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.domain.EvenetBadge;
import christmas.domain.GiveawayMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GiveawayTest extends NsTest {
    @DisplayName("getGiveawayMenuNameTest")
    @Test
    void getGiveawayMenuNameTest() {
        assertSimpleTest(() ->{
            for(GiveawayMenu giveawayMenu : GiveawayMenu.values()) System.out.println(giveawayMenu.getGivewawyMenuName());
            assertThat(output()).contains("샴페인");
        });
    }

    @DisplayName("getGiveawayMenuPriceTest")
    @Test
    void getGiveawayMenuPriceTest() {
        assertSimpleTest(() ->{
            for(GiveawayMenu giveawayMenu : GiveawayMenu.values()) System.out.println(giveawayMenu.getGivewawyMenuPrice());
            assertThat(output()).contains("25000");
        });
    }

    @Override
    protected void runMain() {}
}