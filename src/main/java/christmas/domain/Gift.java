package christmas.domain;

public class Gift {
    private static final Menu MENU = Menu.CHAMPAGNE;
    private static final int COUNT = 1;
    private static final int CRITERIA = 120_000;

    public static boolean isApplicable(int totalPrice) {
        return totalPrice >= CRITERIA;
    }

    public static int calculatePrice() {
        return MENU.calculatePrice(COUNT);
    }

    public static String getMenuName() {
        return MENU.getName();
    }

    public static int getCount() {
        return COUNT;
    }
}
