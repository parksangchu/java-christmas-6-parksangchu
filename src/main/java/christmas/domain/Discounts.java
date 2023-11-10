package christmas.domain;

public enum Discounts {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", 1_000),
    WEEKDAY("평일 할인", 2_023),
    WEEKEND("주말 할인", 2_023),
    SPECIAL("특별 할인", 1_000);

    private final String discountName;
    private final int price;

    Discounts(String discountName, int price) {
        this.discountName = discountName;
        this.price = price;
    }

    public String getDiscountName() {
        return discountName;
    }

    public int getPrice() {
        return price;
    }
}
