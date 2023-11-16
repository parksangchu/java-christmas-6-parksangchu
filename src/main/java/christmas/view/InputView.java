package christmas.view;

import static christmas.domain.Error.INVALID_DATE;
import static christmas.view.Notice.ASK_DATE_OF_VISIT;
import static christmas.view.Notice.ASK_MENU_AND_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readDate() {
        System.out.println(ASK_DATE_OF_VISIT.getMessage());
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    public static String readOrder() {
        System.out.println(ASK_MENU_AND_COUNT.getMessage());
        return Console.readLine();
    }

    private static void validateType(String input) {
        if (hasLetter(input)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private static boolean hasLetter(String input) {
        return input.chars()
                .anyMatch(number -> !Character.isDigit(number));
    }
}
