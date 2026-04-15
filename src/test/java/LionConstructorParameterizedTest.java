package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class LionConstructorParameterizedTest {

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    void lionConstructorShouldSetManeCorrectly(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестно", "Самец1", ""})
    void lionConstructorShouldThrowExceptionForInvalidSex(String invalidSex) {
        assertThrows(Exception.class, () -> new Lion(invalidSex));
    }
}