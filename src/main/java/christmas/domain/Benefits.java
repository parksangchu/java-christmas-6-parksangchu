package christmas.domain;


import static christmas.domain.Badge.NONE;
import static christmas.domain.Badge.SANTA;
import static christmas.domain.Badge.STAR;
import static christmas.domain.Badge.TREE;

import java.util.Map;

public class Benefits {
    private final Map<Event, Integer> benefits;

    public Benefits(Map<Event, Integer> benefits) {
        this.benefits = benefits;
    }

    public int calculateTotalBenefitAmount() {
        return benefits.values()
                .stream()
                .mapToInt(amount -> amount)
                .sum();
    }

    public Badge toEventBadge(int totalBenefit) {
        if (isStarBadge(totalBenefit)) {
            return STAR;
        }
        if (isTreeBadge(totalBenefit)) {
            return TREE;
        }
        if (isSantaBadge(totalBenefit)) {
            return SANTA;
        }
        return NONE;
    }

    private boolean isStarBadge(int totalBenefit) {
        return totalBenefit >= STAR.getAmount() && totalBenefit < TREE.getAmount();
    }

    private boolean isTreeBadge(int totalBenefit) {
        return totalBenefit >= TREE.getAmount() && totalBenefit < SANTA.getAmount();
    }

    private boolean isSantaBadge(int totalBenefit) {
        return totalBenefit >= SANTA.getAmount();
    }

    public Map<Event, Integer> getBenefits() {
        return benefits;
    }
}



