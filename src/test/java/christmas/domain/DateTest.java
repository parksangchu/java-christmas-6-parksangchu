package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {
    @ParameterizedTest
    @DisplayName("1-31 사이의 숫자가 아니면 예외 발생")
    @ValueSource(ints = {0, 32})
    void createDate(int input) {
        assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}