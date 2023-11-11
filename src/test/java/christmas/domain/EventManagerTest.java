package christmas.domain;

import static christmas.global.Event.CHRISTMAS_D_DAY;
import static christmas.global.Event.GIFT;
import static christmas.global.Event.SPECIAL;
import static christmas.global.Event.WEEKDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventManagerTest {

    @Test
    @DisplayName("혜택의 총합 계산")
    void calculateTotalBenefit() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        int totalBenefit = EventManager.calculateTotalBenefit(EventManager.toBenefits(orders, date));
        assertThat(totalBenefit).isEqualTo(31246);
    }

    @Test
    @DisplayName("혜택을 담은 해시맵으로 반환")
    void toBenefits() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        Benefits benefits = EventManager.toBenefits(orders, date);
        assert benefits != null;
        assertThat(benefits.getBenefits().get(CHRISTMAS_D_DAY)).isEqualTo(1_200);
        assertThat(benefits.getBenefits().get(WEEKDAY)).isEqualTo(4_046);
        assertThat(benefits.getBenefits().get(SPECIAL)).isEqualTo(1_000);
        assertThat(benefits.getBenefits().get(GIFT)).isEqualTo(25_000);
    }

    @ParameterizedTest
    @DisplayName("총 혜택 금액에 따른 뱃지 지급")
    @CsvSource(value = {"5500,별", "10500,트리", "21000,산타"})
    void toEventBadge(int input, String expect) {
        String badge = EventManager.toEventBadge(input);
        assertThat(badge).isEqualTo(expect);
    }

    @Test
    @DisplayName("총 결제 금액이 음수이면 0 반환")
    void calculatePaymentAmount() {
        int paymentAmount = EventManager.calculatePaymentAmount(new Orders(List.of(new Order("아이스크림", 1))), 10000,
                20000);
        assertThat(paymentAmount).isEqualTo(0);
    }
}