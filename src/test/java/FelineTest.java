package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void eatMeatShouldReturnPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyShouldReturnCats() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgsShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithArgsShouldReturnGivenNumber() {
        assertEquals(5, feline.getKittens(5));
    }
}