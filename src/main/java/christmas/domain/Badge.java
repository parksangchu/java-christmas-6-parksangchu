package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int limit;

    Badge(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public static Badge of(int totalBenefitAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.limit <= totalBenefitAmount)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
