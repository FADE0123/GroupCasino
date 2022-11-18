package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.Cards;
import com.github.zipcodewilmington.Deck;
import com.github.zipcodewilmington.Suits;
import com.github.zipcodewilmington.casino.players.BlackjackPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class BlackjackPlayerTest {

    @Test
    public void emptyHandTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        Cards card = new Cards(Suits.SPADES, 1);
        player.draw(card);
        assertEquals(1, player.getNumberCards());
        player.emptyHand();
        assertEquals(0, player.getNumberCards());
    }
    @Test
    public void drawTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        player.draw(deck.dealCard());
        assertEquals(2, player.getNumberCards());
    }
    @Test
    public void getHandSumTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        player.draw(deck.dealCard());
        player.cardReveal(true);
        assertEquals(13, player.getHandSum());
    }
    @Test
    public void getNameTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        String expected = "Player";
        assertEquals(player.getname(), expected);
    }
    @Test
    public void getHandTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        Deck deck = new Deck();
        player.draw(deck.dealCard());

        assertEquals("Ace of CLUBS", player.getHand(0).toString());
    }
    @Test
    public void getNumberCardsTest(){
        BlackjackPlayer player = new BlackjackPlayer("Player");
        Deck deck = new Deck();
        player.draw(deck.dealCard());
        assertEquals(1, player.getNumberCards());
    }

}