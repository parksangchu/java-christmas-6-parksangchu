package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Benefits;
import christmas.domain.Convertor;
import christmas.domain.Date;
import christmas.domain.EventManager;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void start() {
        OutputView.printWelcome();
        Date date = createDate();
        Orders orders = createOrders();
        int totalOrderAmount = createTotalOrderAmount(orders);
        OutputView.printGift(orders.hasGift());
        Benefits benefits = createBenefits(orders, date);
        int totalBenefitAmount = createTotalBenefitAmount(benefits);
        createPaymentAmount(orders, totalOrderAmount, totalBenefitAmount);
        createBadge(benefits, totalBenefitAmount);
    }

    private Date createDate() {
        while (true) {
            try {
                Date date = new Date(InputView.readDate());
                OutputView.printPreview(date);
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
                OutputView.printOrders(orders);
                return orders;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private int createTotalOrderAmount(Orders orders) {
        int totalOrderAmount = orders.calculateTotalAmount();
        OutputView.printTotalOrderAmount(totalOrderAmount);
        return totalOrderAmount;
    }

    private Benefits createBenefits(Orders orders, Date date) {
        Benefits benefits = EventManager.toBenefits(orders, date);
        OutputView.printBenefitDetail(benefits);
        return benefits;
    }

    private int createTotalBenefitAmount(Benefits benefits) {
        int totalBenefitAmount = benefits.calculateTotalBenefitAmount();
        OutputView.printTotalBenefitAmount(totalBenefitAmount);
        return totalBenefitAmount;
    }

    private void createPaymentAmount(Orders orders, int totalOrderAmount, int totalBenefitAmount) {
        int paymentAmount = orders.calculatePaymentAmount(totalOrderAmount, totalBenefitAmount);
        OutputView.printPaymentAmount(paymentAmount);
    }

    private void createBadge(Benefits benefits, int totalBenefitAmount) {
        Badge badge = benefits.toEventBadge(totalBenefitAmount);
        OutputView.printEventBadge(badge);
    }
}
