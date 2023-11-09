package christmas.domain;

import java.util.List;

public class Orders {
    private List<Order> orders;


    public Orders(List<Order> orders) {
        this.orders = orders;
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
