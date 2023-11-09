package christmas.domain;

import static christmas.global.Error.INVALID_ORDER;

public class Order {
    private static final String UNIT = "개";
    private String menu;
    private int count;

    public Order(String menu, int count) {
        validateMenu(menu);
        this.menu = menu;
        this.count = count;
    }

    @Override
    public String toString() {
        return menu + " " + count + UNIT;
    }

    private void validateMenu(String menu) {
        if (isInvalidMenu(menu)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isInvalidMenu(String menu) {
        return Menu.from(menu) == null;
    }
}
