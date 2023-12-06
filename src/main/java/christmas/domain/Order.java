package christmas.domain;

public class Order {
    private static final String ORDER_REGEX = "[가-힣]+-[1-9][0-9]*";
    private static final String DELIMITER = "-";
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Menu menu;
    private final int count;

    public Order(String order) {
        validatePattern(order);
        String[] separatedOrder = getSeparatedOrder(order);
        this.menu = getMenu(separatedOrder);
        this.count = getCount(separatedOrder);
    }

    private Menu getMenu(String[] separatedOrder) {
        Menu menu = Menu.of(separatedOrder[0]);
        if (menu.equals(Menu.NONE)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
        return menu;
    }

    private int getCount(String[] separatedOrder) {
        String count = separatedOrder[1];
        return Integer.parseInt(count);
    }

    private static void validatePattern(String order) {
        if (!order.matches(ORDER_REGEX)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
    }

    private static String[] getSeparatedOrder(String order) {
        validatePattern(order);
        return order.split(DELIMITER);
    }
}
