package christmas.domain;

import static christmas.global.Error.INVALID_DATE;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private final int value;

    public Date(int value) {
        validateRange(value);
        this.value = value;
    }

    public DayOfWeek ofWeek() {
        LocalDate localDate = LocalDate.of(2023, 12, value);
        return localDate.getDayOfWeek();
    }

    private void validateRange(int value) {
        if (value > MAX_DATE || value < MIN_DATE) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
