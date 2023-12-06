package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외가 발생한다.")
    void createInvalidMenu() {
        assertThatThrownBy(() -> new Order(("라면-1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        assertThatCode(() -> new Order("바비큐립-1")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1개 미만으로 주문시 에외가 발생한다.")
    void createInvalidCount() {
        assertThatThrownBy(() -> new Order(("바비큐립-0")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("주문 형식이 다를 경우 예외가 발생한다.")
    public void createInvalidPattern() {
        assertThatThrownBy(() -> new Order(("바비큐립,1")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}