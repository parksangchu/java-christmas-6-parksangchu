package christmas.domain;

public class Order {
    private static final String UNIT = "개";
    private String menu;
    private int count;

    public Order(String menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    @Override
    public String toString() {
        return menu + " " + count + UNIT;
    }
}
