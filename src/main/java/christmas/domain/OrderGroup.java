package christmas.domain;

import java.util.List;

public class OrderGroup {
    private final List<Order> orders;
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int MAX_COUNT = 20;

    public OrderGroup(List<Order> orders) {
        validateDuplicated(orders);
        validateSize(orders);
        this.orders = orders;
    }

    private void validateDuplicated(List<Order> orders) {
        if (orders.stream()
                .distinct()
                .count() != orders.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
    }

    private void validateSize(List<Order> orders) {
        if (orders.stream()
                .mapToInt(Order::getCount)
                .sum() > MAX_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
    }

    private void validateCategory(List<Order> orders) {
        if (orders.stream()
                .allMatch(Order::isDrink)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
    }
}
