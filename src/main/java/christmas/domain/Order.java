package christmas.domain;

import static christmas.global.Error.INVALID_ORDER;

import java.util.Objects;

public class Order {
    private static final String UNIT = "개";
    private static final int MIN_ORDER_COUNT = 1;
    private final String menuName;
    private final int count;

    public Order(String menuName, int count) {
        validateMenuName(menuName);
        validateCount(count);
        this.menuName = menuName;
        this.count = count;
    }

    public int calculateByMenu() {
        Menus menu = Menus.from(menuName);
        return menu.getPrice() * count;
    }


    public boolean isBeverage() {
        Menus menu = Menus.from(menuName);
        return menu.getType().equals("음료");
    }

    public int countDessert() {
        if (isDessert()) {
            return count;
        }
        return 0;
    }

    public int countMain() {
        if (isMain()) {
            return count;
        }
        return 0;
    }

    private boolean isDessert() {
        Menus menu = Menus.from(menuName);
        return menu.getType().equals("디저트");
    }

    private boolean isMain() {
        Menus menu = Menus.from(menuName);
        return menu.getType().equals("메인");
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return menuName + " " + count + UNIT;
    }

    private void validateMenuName(String menu) {
        if (isInvalidMenu(menu)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isInvalidMenu(String menu) {
        return Menus.from(menu) == null;
    }

    private void validateCount(int count) {
        if (count < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order order)) {
            return false;
        }
        return Objects.equals(menuName, order.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }
}
