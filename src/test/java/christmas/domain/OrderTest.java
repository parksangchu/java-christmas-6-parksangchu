package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    @DisplayName("디저트가 없으면 0 반환")
    void countDessert() {
        Order order = new Order("초코케이크", 1);
        assertThat(order.countDessert()).isEqualTo(1);
    }

    @Test
    @DisplayName("메인이 있으면 개수 반환")
    void countMain() {
        Order order = new Order("바비큐립", 10);
        int count = order.countMain();
        assertThat(count).isEqualTo(10);
    }

    @Test
    @DisplayName("1개 미만 주문시 예외 발생")
    void countZero() {
        assertThatThrownBy(() -> new Order("바비큐립", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}