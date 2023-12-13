package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public enum Discount {
    D_DAY("크리스마스 디데이 할인", 1_000, 100),
    WEEKDAY("평일 할인", 0, 2_023),
    WEEKEND("주말 할인", 0, 2_023),
    SPECIAL("특별 할인", 1_000, 0);
    private final String name;
    private final int startPrice;
    private final int additionalPrice;

    Discount(String name, int startPrice, int AdditionalPrice) {
        this.name = name;
        this.startPrice = startPrice;
        additionalPrice = AdditionalPrice;
    }

    public static List<Discount> getApplicableDiscounts(VisitDay visitDay) {
        List<Discount> discounts = new ArrayList<>();
        if (visitDay.isBeforeChristmas()) {
            discounts.add(D_DAY);
        }
        if (!visitDay.isWeekend()) {
            discounts.add(WEEKDAY);
        }
        if (visitDay.isWeekend()) {
            discounts.add(WEEKEND);
        }
        if (visitDay.isSpecialDay()) {
            discounts.add(SPECIAL);
        }
        return discounts;
    }
}
