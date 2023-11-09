package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String delimiter = ",";

    public static Orders convertToOrders(String input) {
        List<Order> orders = Arrays.stream(input.split(delimiter))
                .map(Order::new)
                .collect(Collectors.toList());
        return new Orders(orders);
    }
}
