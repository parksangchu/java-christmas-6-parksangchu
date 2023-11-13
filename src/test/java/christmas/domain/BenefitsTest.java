package christmas.domain;

import static christmas.global.Badge.NONE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.global.Badge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BenefitsTest {
    Benefits benefits;

    @Test
    @DisplayName("혜택의 총합 계산")
    void calculateTotalBenefit() {
        int totalBenefit = benefits.calculateTotalBenefitAmount();
        assertThat(totalBenefit).isEqualTo(31246);
    }

    @ParameterizedTest
    @DisplayName("총 혜택 금액에 따른 뱃지 지급")
    @CsvSource(value = {"5500,별", "10500,트리", "21000,산타"})
    void toEventBadge(int input, String expect) {
        Badge badge = benefits.toEventBadge(input);
        if (badge != NONE) {
            assertThat(badge.getType()).isEqualTo(expect);
        }
    }

    @BeforeEach
    void setUp() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        benefits = EventManager.toBenefits(orders, date);
    }
}