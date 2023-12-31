package christmas.domain;

import static christmas.domain.Error.INVALID_ORDER;
import static christmas.domain.Menu.NONE;

import java.util.Objects;

public class Order {
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
        Menu menu = Menu.from(menuName);
        return menu.getPrice() * count;
    }


    public boolean isBeverage() {
        Menu menu = Menu.from(menuName);
        return menu.getType().equals("음료");
    }

    public int countDessert() {
        if (isDessert()) {
            return count;
        }
        return 0;
    }

    private boolean isDessert() {
        Menu menu = Menu.from(menuName);
        return menu.getType().equals("디저트");
    }

    public int countMain() {
        if (isMain()) {
            return count;
        }
        return 0;
    }


    private boolean isMain() {
        Menu menu = Menu.from(menuName);
        return menu.getType().equals("메인");
    }

    public String getMenuName() {
        return menuName;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Order order) {
            return menuName.equals(order.menuName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
    }

    private void validateMenuName(String menu) {
        if (isInvalidMenu(menu)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isInvalidMenu(String menu) {
        return Menu.from(menu) == NONE;
    }

    private void validateCount(int count) {
        if (count < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}
