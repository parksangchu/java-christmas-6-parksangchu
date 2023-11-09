package christmas.domain;

import static christmas.global.Error.INVALID_ORDER;

import java.util.List;

public class Orders {
    private final List<Order> orders;


    public Orders(List<Order> orders) {
        validateDuplicated(orders);
        this.orders = orders;
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

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Order order : orders) {
            output.append(order.toString()).append("\n");
        }
        return output.toString();
    }

    public int calculateTotalAmount() {
        return orders.stream()
                .mapToInt(Order::calculateByMenu)
                .sum();
    }
}
