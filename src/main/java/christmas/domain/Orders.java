package christmas.domain;

import static christmas.global.Error.INVALID_COUNT;
import static christmas.global.Error.INVALID_ORDER;
import static christmas.global.Error.INVALID_TYPE;

import java.util.List;

public class Orders {
    private static final int MAX_TOTAL_ORDER_COUNT = 20;
    private final List<Order> orders;


    public Orders(List<Order> orders) {
        validateDuplicated(orders);
        validateTotalCount(orders);
        validateType(orders);
        this.orders = orders;
    }

    public int calculateTotalAmount() {
        return orders.stream()
                .mapToInt(Order::calculateByMenu)
                .sum();
    }

    private void validateDuplicated(List<Order> orders) {
        if (isDuplicated(orders)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isDuplicated(List<Order> orders) {
        return orders.stream()
                .distinct()
                .count() != orders.size();
    }

    private void validateTotalCount(List<Order> orders) {
        if (calculateTotalCount(orders) > MAX_TOTAL_ORDER_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private int calculateTotalCount(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getCount)
                .sum();
    }

    private void validateType(List<Order> orders) {
        if (isInvalidType(orders)) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }

    private boolean isInvalidType(List<Order> orders) {
        return orders.stream()
                .allMatch(Order::isBeverage);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Order order : orders) {
            output.append(order.toString()).append("\n");
        }
        return output.toString();
    }

}
