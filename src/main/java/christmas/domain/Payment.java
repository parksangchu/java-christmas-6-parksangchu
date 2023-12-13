package christmas.domain;

public class Payment {
    public static int calculateTotalPrice(Orders orders) {
        return orders.calculatePrice();
    }
}
