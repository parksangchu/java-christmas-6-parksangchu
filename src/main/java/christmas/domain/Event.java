package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public enum Event {
    D_DAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0),
    GIFT("증정 이벤트", Gift.calculatePrice(), 0);
    private final String name;
    private final int startPrice;
    private final int additionalPrice;

    Event(String name, int startPrice, int AdditionalPrice) {
        this.name = name;
        this.startPrice = startPrice;
        additionalPrice = AdditionalPrice;
    }

    public static List<Event> getApplicableEvents(VisitDay visitDay, Orders orders) {
        List<Event> events = new ArrayList<>();
        if (visitDay.isBeforeChristmas()) {
            events.add(D_DAY);
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
        addGift(orders, events);
        return events;
    }

    public int calculatePrice(VisitDay visitDay, Orders orders) {
        if (this == D_DAY) {
            return startPrice + visitDay.getChristmasDDAY() * additionalPrice;
        }
        if (this == WEEKDAY) {
            return orders.countDessert() * additionalPrice;
        }
        if (this == WEEKEND) {
            return orders.countMain() * additionalPrice;
        }
        if (this == SPECIAL) {
            return startPrice;
        }
        if (this == GIFT) {
            return startPrice;
        }
        return 0;
    }

    private static void addGift(Orders orders, List<Event> events) {
        if (Gift.isApplicable(Payment.calculateTotalPrice(orders))) {
            events.add(GIFT);
        }
    }

    public String getName() {
        return name;
    }
}
