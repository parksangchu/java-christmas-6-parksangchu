package christmas.view;

import static christmas.global.Menu.CHAMPAGNE;
import static christmas.view.Notice.BENEFIT_LIST;
import static christmas.view.Notice.EVENT_BADGE;
import static christmas.view.Notice.GIFT_MENU;
import static christmas.view.Notice.ORDER_MENU;
import static christmas.view.Notice.PREVIEW;
import static christmas.view.Notice.TOTAL_BENEFIT_AMOUNT;
import static christmas.view.Notice.TOTAL_ORDER_AMOUNT;
import static christmas.view.Notice.TOTAL_PAYMENT_AMOUNT;
import static christmas.view.Notice.WELCOME;

import christmas.domain.Benefits;
import christmas.domain.Date;
import christmas.domain.Orders;
import christmas.global.Badge;

public class OutputView {
    private static final String MONEY_UNIT = "원";
    private static final String COUNT_UNIT = "개";

    private static final String GIFT = CHAMPAGNE.getMenuName() + " 1" + COUNT_UNIT;
    private static final String NO_DATA = "없음";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printWelcome() {
        System.out.println(WELCOME.getMessage());
    }

    public static void printPreview(Date date) {
        System.out.printf(PREVIEW.getMessage(), date.getValue());
    }

    public static void printOrders(Orders orders) {
        System.out.println(ORDER_MENU.getMessage());
        orders.getOrders()
                .forEach(order -> System.out.printf("%s %d%s%n", order.getMenuName(), order.getCount(), COUNT_UNIT));
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

    public static void printBenefitDetail(Benefits benefits) {
        System.out.println(BENEFIT_LIST.getMessage());
        if (isValidValue(benefits)) {
            benefits.getBenefits()
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() != 0)
                    .forEach(entry -> System.out.printf("%s: -%,d%s%n", entry.getKey().getDiscountName(),
                            entry.getValue(),
                            MONEY_UNIT));
            return;
        }
        System.out.println(NO_DATA);
    }

    private static boolean isValidValue(Benefits benefits) {
        return !isZeroValue(benefits) && !isEmpty(benefits);
    }

    private static boolean isZeroValue(Benefits benefits) {
        return benefits.getBenefits()
                .values()
                .stream()
                .allMatch(count -> count == 0);
    }

    private static boolean isEmpty(Benefits benefits) {
        return benefits.getBenefits().isEmpty();
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
        if (totalBenefitAmount > 0) {
            System.out.printf("-%,d%s%n", totalBenefitAmount, MONEY_UNIT);
            return;
        }
        System.out.printf("%,d%s%n", totalBenefitAmount, MONEY_UNIT);
    }

    public static void printPaymentAmount(int PaymentAmount) {
        System.out.println(TOTAL_PAYMENT_AMOUNT.getMessage());
        System.out.printf("%,d%s%n", PaymentAmount, MONEY_UNIT);
    }

    public static void printEventBadge(Badge badge) {
        System.out.println(EVENT_BADGE.getMessage());
        System.out.println(badge.getType());
    }
}
