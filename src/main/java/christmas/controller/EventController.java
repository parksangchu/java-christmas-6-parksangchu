package christmas.controller;

import christmas.domain.Benefit;
import christmas.domain.Convertor;
import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {
    public void start() {
        OutputView.printWelcome();
        Date date = createDate();
        Orders orders = createOrders();
        Map<Event, Integer> benefits = Benefit.toBenefits(orders, date);
        OutputView.printPreview(date);
        OutputView.printOrders(orders);
        OutputView.printTotalOrderAmount(orders.calculateTotalAmount());
        OutputView.printGift(orders.hasGift());
        OutputView.printBenefitList();
        OutputView.printTotalBenefitAmount(Benefit.calculateTotalBenefit(benefits));
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
                Orders orders = Convertor.toOrders(InputView.readOrder());
                return orders;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
