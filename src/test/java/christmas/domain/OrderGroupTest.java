package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderGroupTest {
    @Test
    @DisplayName("메뉴가 중복되면 예외가 발생한다.")
    void createDuplicated() {
        Order order1 = new Order("타파스-1");
        Order order2 = new Order("타파스-2");
        Order order3 = new Order("제로콜라-1");
        assertThatThrownBy(() -> new OrderGroup(List.of(order1, order2)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatCode(() -> new OrderGroup((List.of(order1, order3))))
                .doesNotThrowAnyException();
    }
}