package christmas.domain;


import christmas.global.Event;
import java.util.Map;

public class Benefits {
    private static final String MONEY_UNIT = "개";
    private final Map<Event, Integer> benefits;

    public Benefits(Map<Event, Integer> benefits) {
        this.benefits = benefits;
    }

    public int calculateTotalBenefit() {
        if (benefits != null) {
            return benefits.values()
                    .stream()
                    .mapToInt(amount -> amount)
                    .sum();
        }
        return 0;
    }

    public Map<Event, Integer> getBenefits() {
        return benefits;
    }
}



