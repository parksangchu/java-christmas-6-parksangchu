package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.global.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {
    @ParameterizedTest
    @DisplayName("입력한 문자열에 맞는 메뉴 반환")
    @CsvSource(value = {"양송이수프,MUSHROOM_SOUP", "바비큐립,BBQ_RIBS"})
    void CreateMenu(String input, Menu name) {
        Menu menu = Menu.from(input);
        assertThat(menu).isEqualTo(name);
    }
}