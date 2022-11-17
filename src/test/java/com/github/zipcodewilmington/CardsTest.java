package com.github.zipcodewilmington;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class CardsTest {

    @Test
    public void toStringTest(){
        Cards card = new Cards(Suits.HEARTS, 1);
        String expected = "Ace of HEARTS";
        assertEquals(expected, card.toString());
    }
    @Test
    public void getNumberTest(){
        Cards card = new Cards(Suits.HEARTS, 1);
        int expected = card.getNumber();
        assertEquals(1, expected);
    }

}