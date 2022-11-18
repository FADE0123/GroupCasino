package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.Cards;
import com.github.zipcodewilmington.Deck;
import com.github.zipcodewilmington.Suits;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class WarPlayerTest {

    @Test
    public void emptyHandTest(){
        WarPlayer player = new WarPlayer();
        Cards card = new Cards(Suits.SPADES, 1);
        player.draw(card);
        assertEquals(1, player.getNumberCards());
        player.emptyHand();
        assertEquals(0, player.getNumberCards());
    }
    @Test
    public void drawTest(){
        WarPlayer player = new WarPlayer();
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        assertEquals(1, player.getNumberCards());
    }
    @Test
    public void getHandSumTest(){
        WarPlayer player = new WarPlayer();
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        player.draw(deck.dealCard());
        player.playerCardReveal(true);
        assertEquals(13, player.getHandSum());
    }
    @Test
    public void getHandTest(){
        WarPlayer player = new WarPlayer();
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        assertEquals("Ace of CLUBS", player.getHand(0).toString());
    }
    @Test
    public void getNumberCardsTest(){
        WarPlayer player = new WarPlayer();
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        assertEquals(1, player.getNumberCards());
    }
}