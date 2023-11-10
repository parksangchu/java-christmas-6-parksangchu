package christmas.domain;

import static christmas.domain.Discounts.CHRISTMAS_D_DAY;
import static christmas.domain.Discounts.SPECIAL;
import static christmas.domain.Discounts.WEEKDAY;
import static christmas.domain.Discounts.WEEKEND;
import static christmas.domain.Menus.CHAMPAGNE;

public class Benefit {
    private static final int LOWER_LIMIT_AMOUNT_FOR_BENEFIT = 10_000;
    private static final int UNIT_OF_D_DAY_DISCOUNT = 100;

    public static int calculateTotalBenefit(Orders orders, Date date) {
        if (isEligible(orders)) {
            return calculateDDayDiscount(date)
                    + calculateWeekdayDiscount(orders, date)
                    + calculateWeekendDiscount(orders, date)
                    + calculateSpecialDiscount(date)
                    + calculateGiftAmount(orders);
        }
        return 0;
    }

    public static int calculateDDayDiscount(Date date) {
        if (date.isDayBeforeChristmas()) {
            return CHRISTMAS_D_DAY.getPrice() + ((date.getValue() - 1) * UNIT_OF_D_DAY_DISCOUNT);
        }
        return 0;
    }

    public static int calculateWeekdayDiscount(Orders orders, Date date) {
        if (!date.isWeekend()) {
            return orders.countDesserts() * WEEKDAY.getPrice();
        }
        return 0;
    }

    public static int calculateWeekendDiscount(Orders orders, Date date) {
        if (date.isWeekend()) {
            return orders.countMains() * WEEKEND.getPrice();
        }
        return 0;
    }

    public static int calculateSpecialDiscount(Date date) {
        if (date.isStarDay()) {
            return SPECIAL.getPrice();
        }
        return 0;
    }

    public static int calculateGiftAmount(Orders orders) {
        if (orders.hasGift()) {
            return CHAMPAGNE.getPrice();
        }
        return 0;
    }


    private static boolean isEligible(Orders orders) {
        return orders.calculateTotalAmount() > LOWER_LIMIT_AMOUNT_FOR_BENEFIT;
    }

}
