package com.github.zipcodewilmington;

import java.util.Random;
import java.util.Stack;

public class Deck{
    private static int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final Random randomNumbers = new Random();
    private int numberCards;
    private Cards[] deck;
    private Cards temp;
    public Deck() {
        //One deck without shuffling
        this(1, false);
    }

    public Deck(int numberDecks, boolean shuffle) {
        this.numberCards = numberDecks * 52;
        this.deck = new Cards[this.numberCards];
        int c = 0;
        for(int d = 0; d < numberDecks; d++) {
            for(int i = 0; i < 4; i++) {
                for (int j = 1; j <= 13; j++) {
                    this.deck[c] = new Cards(Suits.values()[i], j);
                    c++;
                }
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }
    public void shuffle() {
        currentCard = 0;
        for(int i = 0; i < this.numberCards; i++) {
            int j = randomNumbers.nextInt(NUMBER_OF_CARDS); //random from 0 - 52;
            temp = this.deck[i]; //temp is empty, deck[i] has ace of spades, right now temp also has ace of spades
            this.deck[i] = this.deck[j]; //deck[i] has ace of spades, deck[j] has king of clubs, deck[i] also has king of clubs
            this.deck[j] = temp; //temp has ace of spades, deck[j] has king of clubs, deck[j] also has ace of spades
        }
    }
    public Cards dealCard() {
        Cards deal = this.deck[0];
        //Shift all cards to the left
        for (int i = 1; i < this.numberCards; i++) {
            this.deck[i - 1] = this.deck[i];
        }
        this.deck[this.numberCards - 1] = null;
        this.numberCards--;
        return deal;
    }
    public void revealDeck(int numberToReveal) {
        for(int i = 0; i < numberToReveal; i++) {
            System.out.printf("% 3d/%d %s\n", i+1, this.numberCards, this.deck[i].toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numberCards-numberToReveal);
    }
}
