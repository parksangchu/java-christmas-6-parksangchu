package christmas.controller;

import christmas.domain.Convertor;
import christmas.domain.Date;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void start() {
        OutputView.printWelcome();
        Date date = createDate();
        Orders orders = createOrders();
        int totalAmount = orders.calculateTotalAmount();
        OutputView.printPreview(date);
        OutputView.printOrders(orders);
        OutputView.printTotalOrderAmount(totalAmount);
        OutputView.printGift();
        OutputView.printBenefitList();
        OutputView.printTotalBenefitAmount();
        OutputView.printPaymentAmount();
        OutputView.printEventBadge();
    }

    private Date createDate() {
        while (true) {
            try {
                Date date = new Date(InputView.readDate());
                return date;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Orders createOrders() {
        while (true) {
            try {
                Orders orders = Convertor.convertToOrders(InputView.readOrder());
                return orders;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
