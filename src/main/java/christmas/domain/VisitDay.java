package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDay {
    private static final int THIS_MONTH = 12;
    private static final int THIS_YEAR = 2023;
    private static final int DAY_START = 1;
    private static final int DAY_END = 31;
    private static final LocalDate THIS_CHRISTMAS = LocalDate.of(THIS_YEAR, THIS_MONTH, 25);

    private final LocalDate localDate;

    public VisitDay(int visitDay) {
        validateRange(visitDay);
        this.localDate = LocalDate.of(THIS_YEAR, THIS_MONTH, visitDay);
    }

    private void validateRange(int visitDay) {
        if (visitDay < DAY_START || visitDay > DAY_END) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DAY.getMessage());
        }
    }

    public boolean isWeekend() {
        return getDayOfWeek() == DayOfWeek.FRIDAY || getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    public boolean isSpecialDay() {
        return getDayOfWeek() == DayOfWeek.SUNDAY || localDate == THIS_CHRISTMAS;
    }

    public boolean isBeforeChristmas() {
        return localDate == THIS_CHRISTMAS || localDate.isBefore(THIS_CHRISTMAS);
    }

    public int getChristmasDDAY() {
        return localDate.getDayOfMonth() - DAY_START;
    }

    private DayOfWeek getDayOfWeek() {
        return localDate.getDayOfWeek();
    }
}
