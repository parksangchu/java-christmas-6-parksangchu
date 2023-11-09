package christmas.domain;

import java.util.List;

public class Orders {
    private List<Order> orders;


    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        String output = "";
        for (Order order : orders) {
            output += order.toString() + "\n";
        }
        return output;
    }

    public void calculateTotalAmount() {
    }
}
