package christmas.domain;


import static christmas.global.Badge.NONE;
import static christmas.global.Badge.SANTA;
import static christmas.global.Badge.STAR;
import static christmas.global.Badge.TREE;

import christmas.global.Badge;
import christmas.global.Event;
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



