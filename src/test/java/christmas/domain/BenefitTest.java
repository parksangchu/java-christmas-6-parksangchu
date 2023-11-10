package christmas.domain;

import static christmas.domain.Event.CHRISTMAS_D_DAY;
import static christmas.domain.Event.GIFT;
import static christmas.domain.Event.SPECIAL;
import static christmas.domain.Event.WEEKDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @Test
    @DisplayName("혜택의 총합 계산")
    void calculateTotalBenefit() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        int totalBenefit = Benefit.calculateTotalBenefit(Benefit.toBenefits(orders, date));
        assertThat(totalBenefit).isEqualTo(31246);
    }

    @Test
    @DisplayName("혜택을 담은 해시맵으로 반환")
    void toBenefits() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Map<Event, Integer> benefits = Benefit.toBenefits(orders, date);
        assertThat(benefits.get(CHRISTMAS_D_DAY)).isEqualTo(1_200);
        assertThat(benefits.get(WEEKDAY)).isEqualTo(4_046);
        assertThat(benefits.get(SPECIAL)).isEqualTo(1_000);
        assertThat(benefits.get(GIFT)).isEqualTo(25_000);
    }
}