package christmas.domain;

import static christmas.domain.Event.CHRISTMAS_D_DAY;
import static christmas.domain.Event.GIFT;
import static christmas.domain.Event.SPECIAL;
import static christmas.domain.Event.WEEKDAY;
import static christmas.domain.Event.WEEKEND;

import java.util.EnumMap;
import java.util.Map;

public class Benefit {
    private static final int LOWER_LIMIT_AMOUNT_FOR_BENEFIT = 10_000;

    public static int calculateTotalBenefit(Map<Event, Integer> benefits) {
        if (benefits != null) {
            return benefits.values()
                    .stream()
                    .mapToInt(amount -> amount)
                    .sum();
        }
        return 0;
    }

    public static Map<Event, Integer> toBenefits(Orders orders, Date date) {
        Map<Event, Integer> benefits = new EnumMap<>(Event.class);
        if (isEligible(orders)) {
            benefits.put(CHRISTMAS_D_DAY, calculateDDayDiscount(date));
            benefits.put(WEEKDAY, calculateWeekdayDiscount(orders, date));
            benefits.put(WEEKEND, calculateWeekendDiscount(orders, date));
            benefits.put(SPECIAL, calculateSpecialDiscount(date));
            benefits.put(GIFT, calculateGiftAmount(orders));
            return benefits;
        }
        return null;
    }

    private static int calculateDDayDiscount(Date date) {
        if (date.isDayBeforeChristmas()) {
            return CHRISTMAS_D_DAY.getInitPrice() + ((date.getValue() - 1) * CHRISTMAS_D_DAY.getUnitPrice());
        }
        return 0;
    }

    private static int calculateWeekdayDiscount(Orders orders, Date date) {
        if (!date.isWeekend()) {
            return orders.countDesserts() * WEEKDAY.getUnitPrice();
        }
        return 0;
    }

    private static int calculateWeekendDiscount(Orders orders, Date date) {
        if (date.isWeekend()) {
            return orders.countMains() * WEEKEND.getUnitPrice();
        }
        return 0;
    }

    private static int calculateSpecialDiscount(Date date) {
        if (date.isStarDay()) {
            return SPECIAL.getInitPrice();
        }
        return 0;
    }

    private static int calculateGiftAmount(Orders orders) {
        if (orders.hasGift()) {
            return GIFT.getInitPrice();
        }
        return 0;
    }


    private static boolean isEligible(Orders orders) {
        return orders.calculateTotalAmount() > LOWER_LIMIT_AMOUNT_FOR_BENEFIT;
    }

}
