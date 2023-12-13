package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class VisitDayTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new VisitDay(32))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.VISIT_DAY.getMessage());
    }
}