package com.example;

import java.util.List;

public class AlexLion extends Lion {

    // Конструктор без параметров — передаёт "Самец" и новый Feline
    public AlexLion() throws Exception {
        super("Самец", new Feline());
    }

    // Конструктор с возможностью передать мок Feline (для тестов)
    public AlexLion(Feline feline) throws Exception {
        super("Самец", feline);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}