package christmas.view;

import christmas.domain.Order;
import java.util.List;

public class OutputView {
    private static final String START_NOTICE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDERS_LABEL = "\n<주문 메뉴>";
    private static final String ORDERS_FORMAT = "%s %d개\n";

    public static void printError(Exception e) {
        System.out.println(e);
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public static void printOrders(List<Order> orders) {
        System.out.println(ORDERS_LABEL);
        orders.forEach(order -> System.out.printf(ORDERS_FORMAT, order.getMenuName(), order.getCount()));
    }
}
