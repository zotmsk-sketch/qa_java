package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Predator mockPredator;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(mockPredator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldReturnWhatPredatorEats() throws Exception {
        List<String> expected = List.of("Meat", "Fish");
        when(mockPredator.eatMeat()).thenReturn(expected);
        Cat cat = new Cat(mockPredator);
        assertEquals(expected, cat.getFood());
    }

    @Test
    void getFoodShouldPropagateException() throws Exception {
        when(mockPredator.eatMeat()).thenThrow(new Exception("Predator error"));
        Cat cat = new Cat(mockPredator);
        assertThrows(Exception.class, cat::getFood);
    }
}