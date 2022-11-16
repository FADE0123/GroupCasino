package com.github.zipcodewilmington;

public enum Suits {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suitText;

    private Suits(String suitText) {
        this.suitText = suitText;
    }
}
