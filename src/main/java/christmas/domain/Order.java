package christmas.domain;

import christmas.util.Util;
import java.util.List;

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
}
