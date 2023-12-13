package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    void create() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order("가-10"))
                .withMessageStartingWith(ErrorMessage.ORDER.getMessage());
        assertThat(new Order("타파스-10").getCount()).isEqualTo(10);
    }


    @Test
    void isMain() {
        Order order = new Order("타파스-1");
        assertThat(order.isMain()).isFalse();
        assertThat(order.isDessert()).isFalse();
        assertThat(order.isDrink()).isFalse();
    }
}