package christmas.domain;

import static christmas.global.Error.INVALID_DATE;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int THIS_YEAR = 2023;
    private static final int THIS_MONTH = 12;
    private static final int CHRISTMAS_DATE = 25;
    private final int value;

    public Date(int value) {
        validateRange(value);
        this.value = value;
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = createDayOfWeek();
        return dayOfWeek == FRIDAY || dayOfWeek == SATURDAY;
    }

    public boolean isStarDay() {
        return createDayOfWeek() == SUNDAY || value == 25;
    }

    private DayOfWeek createDayOfWeek() {
        LocalDate localDate = LocalDate.of(THIS_YEAR, THIS_MONTH, value);
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
