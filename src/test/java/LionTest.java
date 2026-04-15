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
    void getKittensShouldReturnFelineKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(3, lion.getKittens());
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
    void getFoodShouldCallFelineGetFoodWithPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(expected, lion.getFood());
        verify(mockFeline).getFood("Хищник");
    }

    @Test
    void getFoodShouldPropagateException() throws Exception {
        when(mockFeline.getFood("Хищник")).thenThrow(new Exception("Food error"));
        Lion lion = new Lion("Самец", mockFeline);
        assertThrows(Exception.class, lion::getFood);
    }

    @Test
    void constructorWithOnlySexShouldCreateFelineAndSetMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
        assertNotNull(lion.getKittens());
    }
}