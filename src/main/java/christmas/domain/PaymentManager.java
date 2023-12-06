package christmas.domain;

public class PaymentManager {
    private static final int GIFT_MIN_LIMIT = 120_000;

    public static int calculatePaymentAmount(int totalPrice, int totalBenefitAmount) {
        int paymentAmount;
        if (totalPrice >= GIFT_MIN_LIMIT) {
            paymentAmount = totalPrice - totalBenefitAmount - Gift.getPrice();
            return validateZeroValue(paymentAmount);
        }
        paymentAmount = totalPrice - totalBenefitAmount;
        return validateZeroValue(paymentAmount);
    }

    private static int validateZeroValue(int paymentAmount) {
        if (paymentAmount < 0) {
            return 0;
        }
        return paymentAmount;
    }
}

