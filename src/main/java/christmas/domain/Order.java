package christmas.domain;

import static christmas.global.Error.INVALID_ORDER;

public class Order {
    private static final String UNIT = "개";
    private final String menuName;
    private final int count;

    public Order(String menuName, int count) {
        validateMenu(menuName);
        this.menuName = menuName;
        this.count = count;
    }

    public int calculateByMenu() {
        Menu menu = Menu.from(menuName);
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return menuName + " " + count + UNIT;
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
