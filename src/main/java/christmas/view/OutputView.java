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

public class OutputView {
    public static void printWelcome() {
        System.out.println(WELCOME.getMessage());
    }

    public static void printPreview() {
        System.out.println(PREVIEW.getMessage());
        printOrderMenu();
        printTotalOrderAmount();
        printGift();
        printBenefitList();
        printTotalBenefitAmount();
        printPaymentAmount();
        printEventBadge();
    }

    private static void printOrderMenu() {
        System.out.println(ORDER_MENU.getMessage());
    }

    private static void printTotalOrderAmount() {
        System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
    }

    private static void printGift() {
        System.out.println(GIFT.getMessage());
    }

    private static void printBenefitList() {
        System.out.println(BENEFIT_LIST.getMessage());
    }

    private static void printTotalBenefitAmount() {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
    }

    private static void printPaymentAmount() {
        System.out.println(TOTAL_PAYMENT_AMOUNT.getMessage());
    }

    private static void printEventBadge() {
        System.out.println(EVENT_BADGE.getMessage());
    }
}
