package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConvertorTest {

    @ParameterizedTest
    @DisplayName("(한글-숫자),(한글-숫자),,, 형식이 아니면 예외 발생")
    @ValueSource(strings = {"a-1,b-2", "마-1,a-2"})
    void convertToOrdersTest(String input) {
        assertThatThrownBy(() -> Convertor.convertToOrders(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}