package christmas.domain;

import static christmas.domain.Menu.CHAMPAGNE;

public class Gift {
    private static final Menu menu = CHAMPAGNE;
    private static final int count = 1;

    public static String getName() {
        return menu.getName();
    }

    public static int getCount() {
        return count;
    }

    public static int getPrice() {
        return menu.getPrice() * count;
    }
}
