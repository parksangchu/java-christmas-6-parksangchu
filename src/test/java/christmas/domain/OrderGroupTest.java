package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderGroupTest {
    Order order1;
    Order order2;

    @AfterEach
    void tearDown() {
        assertThatThrownBy(() -> new OrderGroup(List.of(order1, order2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메뉴가 중복되면 예외가 발생한다.")
    void createDuplicated() {
        order1 = new Order("타파스-1");
        order2 = new Order("타파스-2");
        Order order3 = new Order("제로콜라-1");
        assertThatCode(() -> new OrderGroup((List.of(order1, order3))))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("총 주문량이 20개를 초과하면 예외가 발생한다.")
    void createOverRange() {
        order1 = new Order("타파스-10");
        order2 = new Order("제로콜라-11");
    }

    @Test
    @DisplayName("음료만 주문하면 예외가 발생한다.")
    public void createOnlyDrink() {
        order1 = new Order("제로콜라-1");
        order2 = new Order("레드와인-1");
    }
}