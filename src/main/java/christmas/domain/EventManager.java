package christmas.domain;

public class EventManager {
    private final VisitDay visitDay;
    private final Orders orders;

    public EventManager(VisitDay visitDay, Orders orders) {
        this.visitDay = visitDay;
        this.orders = orders;
    }
}
