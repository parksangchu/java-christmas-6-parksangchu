package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        VisitDay visitDay = createVisitDay();

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
                List<String> orders = InputView.readOrders();
                return new Orders();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
