package christmas.view;

import static christmas.global.Constants.THIS_MONTH;

import christmas.domain.Order;
import java.util.List;

public class OutputView {
    private static final String START_NOTICE_FORMAT = "안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n";
    private static final String PREVIEW_NOTICE_FORMAT = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDERS_NOTICE = "\n<주문 메뉴>";
    private static final String ORDER_FORMAT = "%s %d개\n";
    private static final String TOTAL_PRICE_FORMAT = "\n<할인 전 총주문 금액>\n%,d원\n";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.printf(START_NOTICE_FORMAT, THIS_MONTH.getValue());
    }

    public static void printPreviewNotice(int day) {
        System.out.printf(PREVIEW_NOTICE_FORMAT, THIS_MONTH.getValue(), day);
    }

    public static void printOrders(List<Order> orders) {
        System.out.println(ORDERS_NOTICE);
        orders.forEach(order
                -> System.out.printf(ORDER_FORMAT, order.getMenuName(), order.getCount()));
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.printf(TOTAL_PRICE_FORMAT, totalPrice);
    }
}
