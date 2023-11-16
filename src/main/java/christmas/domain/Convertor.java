package christmas.domain;

import static christmas.domain.Error.INVALID_ORDER;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Convertor {
    private static final String ORDERS_DELIMITER = ",";
    private static final String ORDER_DELIMITER = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;
    private static final String REGEXP_PATTERN_ORDER = "([가-힣]+)(-)(\\d+)";

    public static Orders toOrders(String input) {
        List<Order> orders = Arrays.stream(input.split(ORDERS_DELIMITER))
                .map(String::trim)
                .map(Convertor::toOrder)
                .collect(Collectors.toList());
        return new Orders(orders);
    }

    private static Order toOrder(String input) {
        validatePattern(input);
        String[] menus = input.split(ORDER_DELIMITER);
        String menuName = menus[MENU_INDEX];
        int count = Integer.parseInt(menus[COUNT_INDEX]);
        return new Order(menuName, count);
    }

    private static void validatePattern(String input) {
        if (!isValidPattern(input)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private static boolean isValidPattern(String input) {
        return Pattern.matches(REGEXP_PATTERN_ORDER, input);
    }

}
