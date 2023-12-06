package christmas.view;

import static christmas.global.Constants.THIS_MONTH;

public class OutputView {
    private static final String START_NOTICE_FORMAT = "안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.\n";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printStartNotice() {
        System.out.printf(START_NOTICE_FORMAT, THIS_MONTH.getValue());
    }
}
