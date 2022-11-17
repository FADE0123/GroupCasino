package com.github.zipcodewilmington;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    @Test
    public void deckOfCardsTest() {
        Deck deck = new Deck();
        System.out.println(List.of(deck.dealCard(52)));
    }
    @Test
    public void popperTest() {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(deck.popper());
    }
    @Test
    public void shuffleTest() {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(List.of(deck.dealCard(52)));
    }
    @Test
    public void FaceDownTest() {
        Deck deck = new Deck();
        String expected = "null of null";
        String actual = String.valueOf(deck.faceDown);
        assertEquals(expected, actual);
    }
    @Test
    public void dealCardFaceDownTest() {
        Deck deck = new Deck();
        deck.dealCardFaceDown(1);
        String expected = String.valueOf(deck.temp[0]);
        String actual = "TWO of CLUBS";
        assertEquals(expected, actual);
    }
    @Test
    public void flipTest() {
        Deck deck = new Deck();
        deck.dealCardFaceDown(1);
        String expected = "TWO of CLUBS";
        String actual = String.valueOf(deck.reveal(0,true));
        assertEquals(expected,actual);
    }
}