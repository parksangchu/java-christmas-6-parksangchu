package christmas.domain;

import java.util.Map;

public class BenefitGroup {
    private final Map<Event, Integer> benefits;

    public BenefitGroup(Map<Event, Integer> benefits) {
        this.benefits = benefits;
    }
}
