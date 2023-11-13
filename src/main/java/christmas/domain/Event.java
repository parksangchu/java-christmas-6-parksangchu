package christmas.domain;

import static christmas.domain.Menu.CHAMPAGNE;

public enum Event {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0),
    GIFT("증정 이벤트", CHAMPAGNE.getPrice(), 0);

    private final String eventName;
    private final int initPrice;
    private final int unitPrice;

    Event(String eventName, int initPrice, int unitPrice) {
        this.eventName = eventName;
        this.initPrice = initPrice;
        this.unitPrice = unitPrice;
    }

    public String getEventName() {
        return eventName;
    }

    public int getInitPrice() {
        return initPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
