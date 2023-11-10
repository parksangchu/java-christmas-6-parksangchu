package christmas.domain;

import static christmas.domain.Menu.CHAMPAGNE;

public class Benefit {
    private static final int LOWER_LIMIT_AMOUNT_FOR_BENEFIT = 10_000;
    private static final int INIT_OF_D_DAY_DISCOUNT = 1_000;
    private static final int UNIT_OF_D_DAY_DISCOUNT = 100;
    private static final int UNIT_OF_WEEKDAY_DISCOUNT = 2_023;
    private static final int UNIT_OF_WEEKEND_DISCOUNT = 2_023;
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    public int calculateTotalBenefit(Orders orders, Date date) {
        if (isEligible(orders)) {
            return calculateDDayDiscount(date)
                    + calculateWeekdayDiscount(orders, date)
                    + calculateWeekendDiscount(orders, date)
                    + calculateSpecialDiscount(date)
                    + calculateGiftAmount(orders);
        }
        return 0;
    }

    private int calculateWeekdayDiscount(Orders orders, Date date) {
        if (!date.isWeekend()) {
            return orders.countDesserts() * UNIT_OF_WEEKDAY_DISCOUNT;
        }
        return 0;
    }

    private int calculateWeekendDiscount(Orders orders, Date date) {
        if (date.isWeekend()) {
            return orders.countMains() * UNIT_OF_WEEKEND_DISCOUNT;
        }
        return 0;
    }

    private int calculateDDayDiscount(Date date) {
        return INIT_OF_D_DAY_DISCOUNT + (date.getValue() * UNIT_OF_D_DAY_DISCOUNT);
    }

    private int calculateSpecialDiscount(Date date) {
        if (date.isStarDay()) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private int calculateGiftAmount(Orders orders) {
        if (orders.hasGift()) {
            return CHAMPAGNE.getPrice();
        }
        return 0;
    }


    private boolean isEligible(Orders orders) {
        return orders.calculateTotalAmount() > LOWER_LIMIT_AMOUNT_FOR_BENEFIT;
    }

}
