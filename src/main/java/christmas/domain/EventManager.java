package christmas.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventManager {
    private static final int LIMIT = 10_000;
    private final VisitDay visitDay;
    private final Orders orders;

    public EventManager(VisitDay visitDay, Orders orders) {
        this.visitDay = visitDay;
        this.orders = orders;
    }

    public Benefits calculateBenefits() {
        Map<Event, Integer> benefits = new EnumMap<>(Event.class);
        if (Payment.calculateTotalPrice(orders) >= LIMIT) {
            List<Event> events = Event.getApplicableEvents(visitDay, orders);
            benefits = events.stream()
                    .filter(event -> event.calculatePrice(visitDay, orders) != 0)
                    .collect(Collectors.toMap(event -> event, event -> event.calculatePrice(visitDay, orders)));
        }
        return new Benefits(new EnumMap<>(benefits));
    }

}
