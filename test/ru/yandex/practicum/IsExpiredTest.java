package ru.yandex.practicum;

import ru.yandex.practicum.delivery.PerishableParcel;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class IsExpiredTest {
    PerishableParcel perishableParcel = new PerishableParcel("test", 20,
            "home", 11, 5);

    @Test
    public void testIsExpiredAtSendDay() {
        assertFalse(perishableParcel.isExpired(11));
    }

    @Test
    public void testIsExpiredAtMiddleDays() {
        assertFalse(perishableParcel.isExpired(13));
    }

    @Test
    public void testIsExpiredAtLastDay() {
        assertFalse(perishableParcel.isExpired(16));
    }

    @Test
    public void testIsExpiredAfterLastDay() {
        assertTrue(perishableParcel.isExpired(17));
        assertTrue(perishableParcel.isExpired(25));

    }
}
