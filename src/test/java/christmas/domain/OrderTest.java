package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Objects;
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

    @Test
    @DisplayName("order의 메뉴 이름이 같으면 동일한 order")
    void testEquals() {
        Order order1 = new Order("바비큐립", 10);
        Order order2 = new Order("바비큐립", 1);
        assertThat(order1.equals(order2)).isEqualTo(true);
        Order order3 = new Order("해산물파스타", 10);
        assertThat(order1.equals(order3)).isEqualTo(false);
        String order4 = "바비큐립";
        assertThat(Objects.equals(order1, order4)).isEqualTo(false);
    }
}