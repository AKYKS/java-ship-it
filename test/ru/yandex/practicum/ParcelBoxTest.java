package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.delivery.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParcelBoxTest {
    ParcelBox<StandardParcel> standardParcelBox;
    StandardParcel standardParcel = new StandardParcel("test", 1,
            "home", 11);
    @BeforeEach
    public void setUp() {
        standardParcelBox = new ParcelBox<>(50);
    }

    @Test
    public void parcelBoxTest() {
        standardParcelBox.addParcel(standardParcel);
        int expectedValue = 1;
        assertEquals(expectedValue, standardParcelBox.getCurrentWeight());
    }

    @Test
    public void parcelBoxTest2() {
        standardParcel.setWeight(50);
        standardParcelBox.addParcel(standardParcel);
        int expectedValue = 50;
        assertEquals(expectedValue, standardParcelBox.getCurrentWeight());
    }

    @Test
    public void parcelBoxTestMoreThenMaxWeight() {
        standardParcel.setWeight(100);
        standardParcelBox.addParcel(standardParcel);
        int expectedValue = 0;
        assertEquals(expectedValue, standardParcelBox.getCurrentWeight());
    }
}
