package christmas.domain;

import java.util.Collections;
import java.util.List;

public class Orders {
    private static final int MAX_COUNT = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateCategory(orders);
        validateDuplicated(orders);
        validateCount(orders);
        this.orders = orders;
    }


    private void validateCategory(List<Order> orders) {
        if (orders.stream()
                .allMatch(Order::isDrink)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.getMessage());
        }
    }

    private void validateDuplicated(List<Order> orders) {
        if (orders.stream()
                .distinct()
                .count() != orders.size()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.getMessage());
        }
    }

    private void validateCount(List<Order> orders) {
        if (orders.stream()
                .mapToInt(Order::getCount)
                .sum() > MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ORDER.getMessage());
        }
    }

    public int calculatePrice() {
        return orders.stream()
                .mapToInt(Order::calculatePrice)
                .sum();
    }

    public int countMain() {
        return orders.stream()
                .filter(Order::isMain)
                .mapToInt(Order::getCount)
                .sum();
    }

    public int countDessert() {
        return orders.stream()
                .filter(Order::isDessert)
                .mapToInt(Order::getCount)
                .sum();
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
