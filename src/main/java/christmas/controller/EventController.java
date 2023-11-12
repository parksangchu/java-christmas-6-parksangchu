package christmas.controller;

import christmas.domain.Benefits;
import christmas.domain.Convertor;
import christmas.domain.Date;
import christmas.domain.EventManager;
import christmas.domain.Orders;
import christmas.global.Badge;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void start() {
        OutputView.printWelcome();
        Date date = createDate();
        Orders orders = createOrders();
        int totalOrderAmount = orders.calculateTotalAmount();
        Benefits benefits = EventManager.toBenefits(orders, date);
        int totalBenefit = benefits.calculateTotalBenefit();
        int PaymentAmount = orders.calculatePaymentAmount(totalOrderAmount, totalBenefit);
        Badge badge = EventManager.toEventBadge(totalBenefit);
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
