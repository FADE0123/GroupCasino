package com.github.zipcodewilmington;

public class Cards {
    private String value;
    private String suit;
    private boolean isFaceUp;
    private Values values;
    private Suits suits;

    public Cards(String cardValue, String cardSuits) {
        value = cardValue;
        suit = cardSuits;
    }
    public Cards(Values values, Suits suits) {
        this.values = values;
        this.suits = suits;
    }
    public Suits getSuit() {
        return suits;
    }
    public Values getValues() {
        return values;
    }
    public int getIntValues() {
        return values.getValues();
    }

    @Override
    public String toString() {
        String str = "";
        str += values + " of " + suits;
        return str;
    }
}