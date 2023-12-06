package christmas.global;

public enum Constants {
    THIS_YEAR(2023),
    THIS_MONTH(12),
    MIN_DAY(1),
    MAX_DAY(31);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
