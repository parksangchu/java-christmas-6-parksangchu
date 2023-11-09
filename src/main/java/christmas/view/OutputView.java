package christmas.view;

import static christmas.view.Notice.BENEFIT_LIST;
import static christmas.view.Notice.EVENT_BADGE;
import static christmas.view.Notice.GIFT;
import static christmas.view.Notice.ORDER_MENU;
import static christmas.view.Notice.PREVIEW;
import static christmas.view.Notice.TOTAL_BENEFIT_AMOUNT;
import static christmas.view.Notice.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;
import static christmas.view.Notice.TOTAL_PAYMENT_AMOUNT;
import static christmas.view.Notice.WELCOME;

import christmas.domain.Date;
import christmas.domain.Orders;

public class OutputView {
    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printWelcome() {
        System.out.println(WELCOME.getMessage());
    }

    public static void printPreview(Date date) {
        System.out.printf(PREVIEW.getMessage(), date);
    }

    public static void printOrders(Orders orders) {
        System.out.println(ORDER_MENU.getMessage());
        System.out.println(orders);
    }

    public static void printTotalOrderAmount() {
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
    }

    public static void printGift() {
        System.out.println(GIFT.getMessage());
    }

    public static void printBenefitList() {
        System.out.println(BENEFIT_LIST.getMessage());
    }

    public static void printTotalBenefitAmount() {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
    }

    public static void printPaymentAmount() {
        System.out.println(TOTAL_PAYMENT_AMOUNT.getMessage());
    }

    public static void printEventBadge() {
        System.out.println(EVENT_BADGE.getMessage());
    }
}
