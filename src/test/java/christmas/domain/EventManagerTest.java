package christmas.domain;

import static christmas.global.Event.CHRISTMAS_D_DAY;
import static christmas.global.Event.GIFT;
import static christmas.global.Event.SPECIAL;
import static christmas.global.Event.WEEKDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventManagerTest {

    @Test
    @DisplayName("혜택을 담은 해시맵으로 반환")
    void toBenefits() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Benefits benefits = EventManager.toBenefits(orders, date);
        assertThat(benefits.getBenefits().get(CHRISTMAS_D_DAY)).isEqualTo(1_200);
        assertThat(benefits.getBenefits().get(WEEKDAY)).isEqualTo(4_046);
        assertThat(benefits.getBenefits().get(SPECIAL)).isEqualTo(1_000);
        assertThat(benefits.getBenefits().get(GIFT)).isEqualTo(25_000);
    }

}