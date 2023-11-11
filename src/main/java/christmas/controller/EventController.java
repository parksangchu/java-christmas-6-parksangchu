package christmas.controller;

import christmas.domain.Calculator;
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
        int totalOrderAmount = orders.calculateTotalAmount();
        Map<Event, Integer> benefits = Calculator.toBenefits(orders, date);
        int totalBenefit = Calculator.calculateTotalBenefit(benefits);
        int PaymentAmount = Calculator.calculatePaymentAmount(orders, totalOrderAmount, totalBenefit);
        String badge = Calculator.toEventBadge(totalBenefit);
        OutputView.printPreview(date);
        OutputView.printOrders(orders);
        OutputView.printTotalOrderAmount(totalOrderAmount);
        OutputView.printGift(orders.hasGift());
        OutputView.printBenefitDetail(benefits);
        OutputView.printTotalBenefitAmount(totalBenefit);
        OutputView.printPaymentAmount(PaymentAmount);
        OutputView.printEventBadge(badge);
    }

    private Date createDate() {
        while (true) {
            try {
                return new Date(InputView.readDate());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Orders createOrders() {
        while (true) {
            try {
                return Convertor.toOrders(InputView.readOrder());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
