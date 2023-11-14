package christmas.domain;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
public enum EventDate {
    YEAR(2023),
    MONTH(12),
    DDAY(25);

    private int date;
    private EventDate(int date){
        this.date=date;
    }

    public int getDate() {return date;}
}
