package christmas.domain;

import java.util.List;

public class OrderGroup {
    private final List<Order> orders;
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final int MAX_COUNT = 20;
    private static final int GIFT_MIN_LIMIT = 120_000;

    public OrderGroup(List<Order> orders) {
        validateDuplicated(orders);
        validateRange(orders);
        validateCategory(orders);
        this.orders = orders;
    }

    private void validateDuplicated(List<Order> orders) {
        if (orders.stream()
                .distinct()
                .count() != orders.size()) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
    }

    private void validateRange(List<Order> orders) {
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

    public int getPrice() {
        return orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public int getDessertCount() {
        return orders.stream()
                .filter(Order::isDessert)
                .mapToInt(Order::getCount)
                .sum();
    }

    public int getMainCount() {
        return orders.stream()
                .filter(Order::isMain)
                .mapToInt(Order::getCount)
                .sum();
    }

    public boolean hasGift() {
        return getPrice() >= GIFT_MIN_LIMIT;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
