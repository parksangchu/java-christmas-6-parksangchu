package christmas.domain;

public class Payment {
    public static int calculateTotalPrice(Orders orders) {
        return orders.calculatePrice();
    }

    public static int calculateTotalBenefitAmount(Benefits benefits) {
        return benefits.calculateBenefitAmount();
    }

    public static int calculatePaymentAmount(Orders orders, Benefits benefits) {
        int totalPrice = calculateTotalPrice(orders);
        int totalBenefitAmount = calculateTotalBenefitAmount(benefits);
        int paymentAmount = totalPrice - totalBenefitAmount;
        if (Gift.isApplicable(totalPrice)) {
            paymentAmount = paymentAmount + Gift.calculatePrice();
        }
        return minusToZero(paymentAmount);
    }

    private static int minusToZero(int paymentAmount) {
        return Math.max(0, paymentAmount);
    }
}
