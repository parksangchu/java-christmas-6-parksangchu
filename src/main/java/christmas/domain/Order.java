package christmas.domain;

import christmas.util.Util;
import java.util.List;
import java.util.Objects;

public class Order {
    private static final String ORDER_REGEX = "^[가-힣]+-[1-9][0-9]*$";
    private final Menu menu;
    private final int count;

    public Order(String order) {
        validatePattern(order);
        List<String> separatedOrder = Util.splitByHyphen(order);
        this.menu = findMenu(separatedOrder);
        this.count = findCount(separatedOrder);
    }

    private void validatePattern(String order) {
        if (!order.matches(ORDER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.getMessage());
        }
    }

    private Menu findMenu(List<String> separatedOrder) {
        return Menu.from(separatedOrder.get(0));
    }

    private int findCount(List<String> separatedOrder) {
        return Integer.parseInt(separatedOrder.get(1));
    }

    public boolean isMain() {
        return MenuCategory.from(menu).isMain();
    }

    public boolean isDessert() {
        return MenuCategory.from(menu).isDessert();
    }

    public boolean isDrink() {
        return MenuCategory.from(menu).isDrink();
    }

    public int calculatePrice() {
        return menu.calculatePrice(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order order)) {
            return false;
        }
        return menu == order.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }
}
