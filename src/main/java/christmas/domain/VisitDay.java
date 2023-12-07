package christmas.domain;

import static christmas.global.Constants.MAX_DAY;
import static christmas.global.Constants.MIN_DAY;
import static christmas.global.Constants.THIS_MONTH;
import static christmas.global.Constants.THIS_YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDay {
    private static final String INVALID_RANGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final LocalDate THIS_CHRISTMAS = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), 25);
    private static final int D_DAY_START = 1;
    private final LocalDate localDate;

    public VisitDay(int day) {
        validateRange(day);
        this.localDate = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), day);
    }

    private void validateRange(int day) {
        if (day < MIN_DAY.getValue() || day > MAX_DAY.getValue()) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public boolean isWeekend() {
        return localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)
                || localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }

    public boolean isSpecialDay() {
        return localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) || localDate.equals(THIS_CHRISTMAS);
    }

    public boolean isBeforeChristmas() {
        return localDate.isBefore(THIS_CHRISTMAS) || localDate.equals(THIS_CHRISTMAS);
    }

    public int calculateDDay() {
        return localDate.getDayOfMonth() - D_DAY_START;
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }
}
