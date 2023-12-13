package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);


    private final String name;
    private final int criteria;

    Badge(String name, int criteria) {
        this.name = name;
        this.criteria = criteria;
    }

    public static Badge from(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> totalBenefitAmount >= badge.criteria)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
