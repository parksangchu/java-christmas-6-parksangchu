package christmas.controller;

import christmas.domain.EventManager;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        VisitDay visitDay = createVisitDay();
        Orders orders = createOrders();

        EventManager eventManager = new EventManager(visitDay, orders);
    }

    private VisitDay createVisitDay() {
        while (true) {
            try {
                int visitDay = InputView.readVisitDay();
                return new VisitDay(visitDay);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Orders createOrders() {
        while (true) {
            try {
                List<String> input = InputView.readOrders();
                List<Order> orders = input.stream()
                        .map(order -> new Order(order))
                        .collect(Collectors.toList());
                return new Orders(orders);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}