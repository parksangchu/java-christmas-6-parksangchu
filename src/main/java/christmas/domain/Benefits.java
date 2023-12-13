package christmas.domain;

import java.util.Collections;
import java.util.Map;

public class Benefits {
    private final Map<Event, Integer> benefits;

    public Benefits(Map<Event, Integer> benefits) {
        this.benefits = benefits;
    }

    public Map<Event, Integer> getBenefits() {
        return Collections.unmodifiableMap(benefits);
    }
}
