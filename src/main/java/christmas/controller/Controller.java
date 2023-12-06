package christmas.controller;

import christmas.domain.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        VisitDay visitDay = initVisitDay();
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
}
