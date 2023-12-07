package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @ParameterizedTest
    @DisplayName("금요일과 토요일은 주말이다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isWeekend(int input) {
        assertThat(new VisitDay(input).isWeekend())
                .isTrue();
        assertThat(new VisitDay(31).isWeekend())
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("일요일과 크리스마스는 스페셜데이다.")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    void isSpecialDay(int input) {
        assertThat(new VisitDay(input).isSpecialDay())
                .isTrue();
        assertThat(new VisitDay(4).isSpecialDay())
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("1-25일은 크리스마스 이전이다.")
    @ValueSource(ints = {1, 3, 5, 10, 15, 17, 25})
    void isBeforeChristmas(int input) {
        assertThat(new VisitDay(input).isBeforeChristmas())
                .isTrue();
        assertThat(new VisitDay(26).isBeforeChristmas())
                .isFalse();
    }
}