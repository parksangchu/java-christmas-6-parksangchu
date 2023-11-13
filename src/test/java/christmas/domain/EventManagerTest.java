package christmas.domain;

import static christmas.domain.Event.CHRISTMAS_D_DAY;
import static christmas.domain.Event.GIFT;
import static christmas.domain.Event.SPECIAL;
import static christmas.domain.Event.WEEKDAY;
import static christmas.domain.Event.WEEKEND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EventManagerTest {
    Date date;
    Orders orders;
    Benefits benefits;

    @Nested
    class ToBenefitsTestByDate {
        @Test
        @DisplayName("3일에는 디데이할인, 스페셜할인, 평일할인 적용")
        void three() {
            assertThat(benefits.getBenefits().get(CHRISTMAS_D_DAY)).isEqualTo(1_200);
            assertThat(benefits.getBenefits().get(WEEKDAY)).isEqualTo(4_046);
            assertThat(benefits.getBenefits().get(WEEKEND)).isEqualTo(0);
            assertThat(benefits.getBenefits().get(SPECIAL)).isEqualTo(1_000);
        }

        @Test
        @DisplayName("30일에는 주말할인 적용")
        void thirty() {
            date = new Date(30);
            benefits = EventManager.toBenefits(orders, date);
            assertThat(benefits.getBenefits().get(CHRISTMAS_D_DAY)).isEqualTo(0);
            assertThat(benefits.getBenefits().get(WEEKDAY)).isEqualTo(0);
            assertThat(benefits.getBenefits().get(WEEKEND)).isEqualTo(4_046);
            assertThat(benefits.getBenefits().get(SPECIAL)).isEqualTo(0);
        }
    }

    @Nested
    class ToBenefitsTestByGift {

        @Test
        @DisplayName("12만원 이상 주문시 증정 혜택")
        void Success() {
            assertThat(benefits.getBenefits().get(GIFT)).isEqualTo(25_000);
        }

        @Test()
        @DisplayName("12만원 미만 주문시 증정 혜택 제공 X")
        void toBenefitsByGiftFail() {
            orders = Convertor.toOrders("티본스테이크-1");
            benefits = EventManager.toBenefits(orders, date);
            assertThat(benefits.getBenefits().get(GIFT)).isEqualTo(0);
        }
    }

    @BeforeEach
    void setUp() {
        orders = Convertor.toOrders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        date = new Date(3);
        benefits = EventManager.toBenefits(orders, date);
    }
}