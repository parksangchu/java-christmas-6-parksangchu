package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.ErrorMessage;
import java.util.List;

public class InputView {
    private static final String ASK_VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String NUM_REGEX = "^[0-9]+$";
    private static final String ASK_ORDERS = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String DELIMITER = ",";

    public static int readVisitDay() {
        System.out.println(ASK_VISIT_DAY);
        String visitDay = Console.readLine();
        validateType(visitDay);
        return Integer.parseInt(visitDay);
    }

    private static void validateType(String visitDay) {
        if (visitDay.matches(NUM_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DAY.getMessage());
        }
    }

    public static List<String> readOrders() {
        System.out.println(ASK_ORDERS);
        
    }
}
