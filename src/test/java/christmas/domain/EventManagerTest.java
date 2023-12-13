package christmas.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

class EventManagerTest {

    @Test
    void calculateBenefits() {
        VisitDay visitDay = new VisitDay(3);
        Orders orders = new Orders(List.of(new Order("티본스테이크-1")
                , new Order("바비큐립-1")
                , new Order("초코케이크-2")
                , new Order("제로콜라-1")));
        EventManager eventManager = new EventManager(visitDay, orders);
        Benefits benefits = eventManager.calculateBenefits();
        benefits.getBenefits().forEach((key, value) -> System.out.println(key.getName() + " " + value));
    }
}