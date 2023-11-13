package christmas.domain;

import static christmas.domain.Error.INVALID_COUNT;
import static christmas.domain.Error.INVALID_ORDER;
import static christmas.domain.Error.INVALID_TYPE;

import java.util.List;

public class Orders {
    private static final int MAX_TOTAL_ORDER_COUNT = 20;
    private static final int LOWER_LIMIT_AMOUNT_FOR_GIFT = 120_000;
    private final List<Order> orders;


    public Orders(List<Order> orders) {
        validateDuplicated(orders);
        validateTotalCount(orders);
        validateType(orders);
        this.orders = orders;
    }

    public int calculatePaymentAmount(int totalAmount, int totalBenefit) {
        int paymentAmount = totalAmount - totalBenefit;
        if (hasGift()) {
            paymentAmount += Event.GIFT.getInitPrice();
            paymentAmount = minusValueToZero(paymentAmount);
            return paymentAmount;
        }
        paymentAmount = minusValueToZero(paymentAmount);
        return paymentAmount;
    }

    private int minusValueToZero(int paymentAmount) {
        return Math.max(paymentAmount, 0);
    }

    public int calculateTotalAmount() {
        return orders.stream()
                .mapToInt(Order::calculateByMenu)
                .sum();
    }

    public boolean hasGift() {
        return calculateTotalAmount() >= LOWER_LIMIT_AMOUNT_FOR_GIFT;
    }

    public int countDesserts() {
        return orders.stream()
                .mapToInt(Order::countDessert)
                .sum();
    }

    public int countMains() {
        return orders.stream()
                .mapToInt(Order::countMain)
                .sum();
    }

    public List<Order> getOrders() {
        return orders;
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


}
