package christmas.domain;

public enum Dessert implements Menu {
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000);

    private final String menu;
    private final int price;

    Dessert(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
