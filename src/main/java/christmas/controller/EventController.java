package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void start() {
        OutputView.printWelcome();
        Date date = new Date(InputView.readDate());
        Orders orders = new Orders(InputView.readOrder());
        OutputView.printPreview(date);
        OutputView.printOrderMenu();
        OutputView.printTotalOrderAmount();
        OutputView.printGift();
        OutputView.printBenefitList();
        OutputView.printTotalBenefitAmount();
        OutputView.printPaymentAmount();
        OutputView.printEventBadge();
    }
}
