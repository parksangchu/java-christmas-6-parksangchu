package christmas.view;

import static christmas.domain.Menu.CHAMPAGNE;
import static christmas.view.Notice.BENEFIT_LIST;
import static christmas.view.Notice.EVENT_BADGE;
import static christmas.view.Notice.GIFT_MENU;
import static christmas.view.Notice.ORDER_MENU;
import static christmas.view.Notice.PREVIEW;
import static christmas.view.Notice.TOTAL_BENEFIT_AMOUNT;
import static christmas.view.Notice.TOTAL_ORDER_AMOUNT;
import static christmas.view.Notice.TOTAL_PAYMENT_AMOUNT;
import static christmas.view.Notice.WELCOME;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Orders;
import java.util.Map;

public class OutputView {
    private static final String MONEY_UNIT = "원";
    private static final String GIFT = CHAMPAGNE.getMenuName() + " 1개";
    private static final String NO_DATA = "없음";

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

    public static void printTotalOrderAmount(int totalAmount) {
        System.out.println(TOTAL_ORDER_AMOUNT.getMessage());
        System.out.printf("%,d%s%n", totalAmount, MONEY_UNIT);
    }

    public static void printGift(boolean hasGift) {
        System.out.println(GIFT_MENU.getMessage());
        if (hasGift) {
            System.out.println(GIFT);
            return;
        }
        System.out.println(NO_DATA);
    }

    public static void printBenefitDetail(Map<Event, Integer> benefits) {
        System.out.println(BENEFIT_LIST.getMessage());
        if (benefits != null) {
            benefits.entrySet()
                    .stream()
                    .forEach(benefit -> System.out.printf("%s: -%,d%s%n", benefit.getKey(), benefit.getValue(),
                            MONEY_UNIT));
            return;
        }
        System.out.println(NO_DATA);
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
        System.out.printf("-%,d%s%n", totalBenefitAmount, MONEY_UNIT);
    }

    public static void printPaymentAmount(int totalPaymentAmount) {
        System.out.println(TOTAL_PAYMENT_AMOUNT.getMessage());
        System.out.printf("-%,d%s%n", totalPaymentAmount, MONEY_UNIT);
    }

    public static void printEventBadge() {
        System.out.println(EVENT_BADGE.getMessage());
    }
}
