package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDayTest {
    @ParameterizedTest
    @DisplayName("1-31 이외의 날짜를 입력할 경우 예외를 발생시킨다.")
    @ValueSource(ints = {0, 32, 100})
    void createInvalidRange(int input) {
        assertThatThrownBy(() -> new VisitDay(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}