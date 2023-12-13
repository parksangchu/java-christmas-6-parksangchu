package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersTest {
    @Test
    void create() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Orders(List.of(new Order("타파스-1"), new Order("레드와인-20"))))
                .withMessageStartingWith(ErrorMessage.ORDER.getMessage());

    }

    @Test
    void calculatePrice() {
        Orders orders = new Orders(List.of(new Order("타파스-1"), new Order("레드와인-1")));
        assertThat(orders.calculatePrice()).isEqualTo(5500 + 60000);
    }
}