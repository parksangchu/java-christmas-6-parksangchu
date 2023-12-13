package christmas.domain;

import static christmas.domain.Menu.BBQ_RIB;
import static christmas.domain.Menu.CAESAR_SALAD;
import static christmas.domain.Menu.CHAMPAGNE;
import static christmas.domain.Menu.CHOCO_CAKE;
import static christmas.domain.Menu.CHRISTMAS_PASTA;
import static christmas.domain.Menu.ICE_CREAM;
import static christmas.domain.Menu.MUSHROOM_SOUP;
import static christmas.domain.Menu.RED_WINE;
import static christmas.domain.Menu.SEAFOOD_PASTA;
import static christmas.domain.Menu.TAPAS;
import static christmas.domain.Menu.T_BONE_STEAK;
import static christmas.domain.Menu.ZERO_COKE;

import java.util.Arrays;
import java.util.List;

public enum MenuCategory {
    APPETIZER(List.of(MUSHROOM_SOUP, TAPAS, CAESAR_SALAD)),
    MAIN(List.of(T_BONE_STEAK, BBQ_RIB, SEAFOOD_PASTA, CHRISTMAS_PASTA)),
    DESSERT(List.of(CHOCO_CAKE, ICE_CREAM)),
    DRINK(List.of(ZERO_COKE, RED_WINE, CHAMPAGNE));

    private final List<Menu> menus;

    MenuCategory(List<Menu> menus) {
        this.menus = menus;
    }

    public static MenuCategory from(Menu menu) {
        return Arrays.stream(values())
                .filter(menuCategory -> menuCategory.menus.contains(menu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ORDER.getMessage()));
    }

    public boolean isMain() {
        return this == MAIN;
    }

    public boolean isDessert() {
        return this == DESSERT;
    }

    public boolean isDrink() {
        return this == DRINK;
    }
}
