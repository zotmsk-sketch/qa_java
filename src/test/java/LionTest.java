package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline mockFeline;

    @Test
    void getKittensShouldReturnValueFromFeline() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void getKittensShouldCallFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        lion.getKittens();
        verify(mockFeline).getKittens();
    }

    @Test
    void doesHaveManeShouldReturnTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeShouldReturnFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFoodShouldReturnValueFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(expected, lion.getFood());
    }

    @Test
    void getFoodShouldCallFelineGetFoodWithPredator() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        lion.getFood();
        verify(mockFeline).getFood("Хищник");
    }

    @Test
    void getFoodShouldPropagateException() throws Exception {
        when(mockFeline.getFood("Хищник")).thenThrow(new Exception("Food error"));
        Lion lion = new Lion("Самец", mockFeline);
        assertThrows(Exception.class, lion::getFood);
    }

    @Test
    void constructorShouldThrowExceptionForInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно", mockFeline));
    }
}