package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public enum Event {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0),
    GIFT("증정 이벤트", Gift.getPrice(), 0);

    private final String name;
    private final int startPrice;
    private final int additionalPrice;

    Event(String name, int startPrice, int additionalPrice) {
        this.name = name;
        this.startPrice = startPrice;
        this.additionalPrice = additionalPrice;
    }

    public static List<Event> findApplicableDiscounts(VisitDay visitDay) {
        List<Event> events = new ArrayList<>();
        if (visitDay.isBeforeChristmas()) {
            events.add(CHRISTMAS_D_DAY);
        }
        if (!visitDay.isWeekend()) {
            events.add(WEEKDAY);
        }
        if (visitDay.isWeekend()) {
            events.add(WEEKEND);
        }
        if (visitDay.isSpecialDay()) {
            events.add(SPECIAL);
        }
        return events;
    }

    public String getName() {
        return name;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public int getAdditionalPrice() {
        return additionalPrice;
    }
}
