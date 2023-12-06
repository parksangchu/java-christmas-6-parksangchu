package christmas.controller;

import christmas.domain.Order;
import christmas.domain.OrderGroup;
import christmas.domain.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        VisitDay visitDay = initVisitDay();
        OrderGroup orderGroup = initOrderGroup();
        OutputView.printPreviewNotice(visitDay.getDay());
        OutputView.printOrders(orderGroup.getOrders());
    }

    private VisitDay initVisitDay() {
        while (true) {
            try {
                return new VisitDay(InputView.readVisitDay());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private OrderGroup initOrderGroup() {
        while (true) {
            try {
                List<String> ordersInput = InputView.readOrders();
                List<Order> orders = ordersInput.stream()
                        .map(Order::new)
                        .collect(Collectors.toList());
                return new OrderGroup(orders);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
