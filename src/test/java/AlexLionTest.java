package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexLionTest {

    @Mock
    private Feline mockFeline;

    @Test
    void constructorShouldSetMale() throws Exception {
        AlexLion alex = new AlexLion();
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void constructorWithFelineShouldSetMale() throws Exception {
        AlexLion alex = new AlexLion(mockFeline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void getKittensShouldReturnZero() throws Exception {
        AlexLion alex = new AlexLion();
        assertEquals(0, alex.getKittens());
    }

    @Test
    void getFriendsShouldReturnListOfFriends() throws Exception {
        AlexLion alex = new AlexLion();
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    void getPlaceOfLivingShouldReturnNYZoo() throws Exception {
        AlexLion alex = new AlexLion();
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}