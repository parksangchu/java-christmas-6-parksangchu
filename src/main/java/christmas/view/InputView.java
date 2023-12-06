package christmas.view;

import static christmas.global.Constants.THIS_MONTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_VISIT_DAY_FORMAT = "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
    private static final String ASK_ORDERS = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String NUMBER_REGEX = "[0-9]+";
    private static final String DELIMITER = ",";
    private static final String INVALID_TYPE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static int readVisitDay() {
        System.out.printf(ASK_VISIT_DAY_FORMAT, THIS_MONTH.getValue());
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    private static void validateType(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR);
        }
    }

    private static List<String> readOrders() {
        System.out.println(ASK_ORDERS);
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
