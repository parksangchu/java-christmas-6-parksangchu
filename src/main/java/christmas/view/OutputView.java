package christmas.view;

public class OutputView {
    private static final String START_NOTICE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public static void printError(Exception e) {
        System.out.println(e);
    }

    public static void printStartNotice() {
        System.out.println(START_NOTICE);
    }
    
}
