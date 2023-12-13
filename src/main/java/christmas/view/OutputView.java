package christmas.view;

import christmas.domain.Event;
import christmas.domain.Gift;
import christmas.domain.Order;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String START_NOTICE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String NONE = "없음";
    private static final String ORDERS_LABEL = "\n<주문 메뉴>";
    private static final String ORDERS_FORMAT = "%s %d개\n";
    private static final String TOTAL_PRICE_FORMAT = "\n<할인 전 총주문 금액>\n%,d원\n";
    private static final String GIFT_LABEL = "\n<증정 메뉴>";
    private static final String GIFT_FORMAT = "%s %d개\n";
    private static final String BENEFITS_LABEL = "\n<혜택 내역>";
    private static final String BENEFITS_FORMAT = "%s: -%,d원\n";
    private static final String TOTAL_BENEFIT_AMOUNT_LABEL = "\n<총혜택 금액>";
    private static final String TOTAL_BENEFIT_AMOUNT_FORMAT = "-%,d원\n";
    private static final String ZERO_WON = "0원";
    private static final String PAYMENT_AMOUNT_FORMAT = "\n<할인 후 예상 결제 금액>\n%,d원\n";
    private static final String BADGE_FORMAT = "\n<12월 이벤트 배지>\n%s\n";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public static void printOrders(List<Order> orders) {
        System.out.println(ORDERS_LABEL);
        orders.forEach(order -> System.out.printf(ORDERS_FORMAT, order.getMenuName(), order.getCount()));
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(TOTAL_PRICE_FORMAT, totalPrice);
    }

    public static void printGift(boolean applicable) {
        System.out.println(GIFT_LABEL);
        if (applicable) {
            System.out.printf(GIFT_FORMAT, Gift.getMenuName(), Gift.getCount());
            return;
        }
        System.out.println(NONE);
    }

    public static void printBenefits(Map<Event, Integer> benefits) {
        System.out.println(BENEFITS_LABEL);
        if (benefits.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        benefits.forEach((key, value) -> System.out.printf(BENEFITS_FORMAT, key.getName(), value));
    }

    public static void printTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT_LABEL);
        if (totalBenefitAmount == 0) {
            System.out.println(ZERO_WON);
            return;
        }
        System.out.printf(TOTAL_BENEFIT_AMOUNT_FORMAT, totalBenefitAmount);
    }

    public static void printPaymentAmount(int paymentAmount) {
        System.out.printf(PAYMENT_AMOUNT_FORMAT, paymentAmount);
    }

    public static void printBadge(String badgeName) {
        System.out.printf(BADGE_FORMAT, badgeName);
    }
}
