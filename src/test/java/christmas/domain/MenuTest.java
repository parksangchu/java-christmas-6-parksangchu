package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {

    @ParameterizedTest
    @DisplayName("메뉴 이름을 확인하여 메뉴를 반환한다.")
    @CsvSource(value = {"양송이수프,MUSHROOM_SOUP", "해산물파스타,SEAFOOD_PASTA", "샴페인,CHAMPAGNE", "상추,NONE"})
    void of(String input, String expect) {
        Menu menu = Menu.of(input);
        assertThat(menu.name()).isEqualTo(expect);
    }
}