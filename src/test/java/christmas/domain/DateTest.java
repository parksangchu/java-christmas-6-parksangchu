package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @ParameterizedTest
    @DisplayName("입력 받은 날짜는 주말이다")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isWeekend(int input) {
        Date date = new Date(input);
        assertThat(date.isWeekend()).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("입력 받은 날짜는 스타데이다")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void isStarDay(int input) {
        Date date = new Date(input);
        assertThat(date.isStarDay()).isEqualTo(true);
    }
}