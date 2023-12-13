package christmas.domain;

public class Payment {
    public static int calculateTotalPrice(Orders orders) {
        return orders.calculatePrice();
    }

    public static int calculateTotalBenefitAmount(Benefits benefits) {
        return benefits.calculateBenefitAmount();
    }
}
