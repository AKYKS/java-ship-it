package ru.yandex.practicum;

import ru.yandex.practicum.delivery.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    @Test
    void testDeliveryCostForStandardParcel() {
        StandardParcel standardParcel = new StandardParcel("test", 20,
                "home", 11);
        int expectedValue = 40;
        assertEquals(expectedValue, standardParcel.calculateDeliveryCost());
    }

    @Test
    void testDeliveryCostForFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel("test", 20,
                "home", 11);
        int expectedValue = 80;
        assertEquals(expectedValue, fragileParcel.calculateDeliveryCost());
    }

    @Test
    void testDeliveryCostForPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("test", 20,
                "home", 11, 5);
        int expectedValue = 60;
        assertEquals(expectedValue, perishableParcel.calculateDeliveryCost());
    }
}
