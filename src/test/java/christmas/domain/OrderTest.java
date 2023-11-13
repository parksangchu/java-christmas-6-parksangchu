package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        assertThat(order.countMain()).isEqualTo(10);
    }

    @Test
    @DisplayName("삼각깁밥은 메뉴에 없기에 0 반환")
    void calculateByMenu() {
        Order order = new Order("삼각깁밥", 10);
        assertThat(order.calculateByMenu()).isEqualTo(0);
    }
}