package com.github.zipcodewilmington;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class DeckTest {

    @Test
    public void getNumberCardsTest() {
        Deck deck = new Deck(3, false);
        int expected = deck.getNumberCards();
        assertEquals(156, expected);
    }
    @Test
    public void dealCardTest() {
        Deck deck = new Deck();
        Cards expected = deck.dealCard();
        assertEquals("Ace of CLUBS", expected.toString());
    }
    @Test
    public void revealDeckTest() {
        Deck deck = new Deck();
        deck.revealDeck(2);
        String expected = String.format("% 3d/%d %s\n% 3d/%d %s\n\t\t[%d other]\n",
                1, 52, "Ace of CLUBS", 2, 52, "Two of CLUBS", 50);
    }
    @Test
    public void shuffleTest() {
        Deck deck = new Deck();
        Cards unshuffled = deck.dealCard();
        deck.shuffle();
        Cards expected = deck.dealCard();
        assertTrue("Card is not :" + unshuffled, expected != unshuffled);
    }
}