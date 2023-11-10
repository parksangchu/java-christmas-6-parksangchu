package christmas.domain;

import static java.time.DayOfWeek.SUNDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.time.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("숫자를 입력받아 요일 생성")
    void createDayOfWeek() {
        Date date = new Date(31);
        DayOfWeek dayOfWeek = date.createDayOfWeek();
        assertThat(dayOfWeek).isEqualTo(SUNDAY);
    }
}