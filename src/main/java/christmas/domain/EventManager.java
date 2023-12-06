package christmas.domain;

import static christmas.domain.Event.CHRISTMAS_D_DAY;
import static christmas.domain.Event.GIFT;
import static christmas.domain.Event.SPECIAL;
import static christmas.domain.Event.WEEKDAY;
import static christmas.domain.Event.WEEKEND;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private static final int MIN_TOTAL_PRICE = 10_000;
    private static final int DISCOUNT_MIN_LIMIT = 0;

    public static Map<Event, Integer> createBenefits(VisitDay visitDay, OrderGroup orderGroup) {
        Map<Event, Integer> benefits = new EnumMap<>(Event.class);
        if (MIN_TOTAL_PRICE <= orderGroup.getPrice()) {
            List<Event> events = Event.findApplicableDiscounts(visitDay);
            for (Event event : events) {
                int discount = calculateDiscount(event, visitDay, orderGroup);
                putBenefit(benefits, event, discount);
            }
        }
        if (orderGroup.hasGift()) {
            benefits.put(GIFT, GIFT.getStartPrice());
        }
        return benefits;
    }

    private static int calculateDiscount(Event event, VisitDay visitDay, OrderGroup orderGroup) {
        if (event.equals(CHRISTMAS_D_DAY)) {
            return calculateDDayDiscount(visitDay);
        }
        if (event.equals(WEEKDAY)) {
            return calculateWeekdayDiscount(orderGroup);
        }
        if (event.equals(WEEKEND)) {
            return calculateWeekendDiscount(orderGroup);
        }
        return calculateSpecialDiscount();
    }

    private static int calculateDDayDiscount(VisitDay visitDay) {
        return CHRISTMAS_D_DAY.getStartPrice() + CHRISTMAS_D_DAY.getAdditionalPrice() * visitDay.calculateDDay();
    }

    private static int calculateWeekdayDiscount(OrderGroup orderGroup) {
        return WEEKDAY.getAdditionalPrice() * orderGroup.getDessertCount();
    }

    private static int calculateWeekendDiscount(OrderGroup orderGroup) {
        return WEEKEND.getAdditionalPrice() * orderGroup.getMainCount();
    }

    private static int calculateSpecialDiscount() {
        return SPECIAL.getStartPrice();
    }

    private static void putBenefit(Map<Event, Integer> benefits, Event event, int discount) {
        if (discount > DISCOUNT_MIN_LIMIT) {
            benefits.put(event, discount);
        }
    }
}

