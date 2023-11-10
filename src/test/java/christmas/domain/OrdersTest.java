package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    @Test
    @DisplayName("중복 주문시 예외 발생")
    void createDuplicated() {
        assertThatThrownBy(() -> new Orders(List.of(new Order("해산물파스타", 1), new Order("해산물파스타", 2))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("20개 이상 주문시 예외 발생")
    void createOverCount() {
        assertThatThrownBy(() -> new Orders(List.of(new Order("해산물파스타", 21))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음료만 주문시 예외 발생")
    void createOnlyBeverage() {
        assertThatThrownBy(() -> new Orders(List.of(new Order("제로콜라", 1), new Order("레드와인", 2))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총 주문 금액 계산")
    void calculateTotalAmount() {
        Orders orders = new Orders(List.of(new Order("제로콜라", 10), new Order("해산물파스타", 10)));
        int result = orders.calculateTotalAmount();
        assertThat(result).isEqualTo(30000 + 350000);
    }

    @Test
    @DisplayName("티본스테이크 3개 주문시 사은품 증정")
    void hasGift() {
        Orders orders = Convertor.convertToOrders("티본스테이크-3");
        assertThat(orders.hasGift()).isEqualTo(true);
    }

}