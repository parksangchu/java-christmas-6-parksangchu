package christmas.view;

import static christmas.global.Constants.THIS_MONTH;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_VISIT_DAY_FORMAT = "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n";
    private static final String NUMBER_REGEX = "[0-9]+";
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
}
