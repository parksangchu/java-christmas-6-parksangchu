package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @Test
    @DisplayName("혜택의 총합 계산")
    void calculateTotalBenefit() {
        Date date = new Date(3);
        Orders orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        int totalBenefit = Benefit.calculateTotalBenefit(orders, date);
        assertThat(totalBenefit).isEqualTo(31246);
    }
}