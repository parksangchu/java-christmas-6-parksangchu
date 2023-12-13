package christmas.domain;

import java.util.Collections;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }
    
    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
