package christmas.domain;

import static christmas.domain.Menu.CHAMPAGNE;

public enum Event {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0),
    GIFT("증정 이벤트", CHAMPAGNE.getPrice(), 0);

    private final String discountName;
    private final int initPrice;
    private final int unitPrice;

    Event(String discountName, int initPrice, int unitPrice) {
        this.discountName = discountName;
        this.initPrice = initPrice;
        this.unitPrice = unitPrice;
    }

    public String getDiscountName() {
        return discountName;
    }

    public int getInitPrice() {
        return initPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
