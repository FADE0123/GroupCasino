package com.github.zipcodewilmington;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private Stack<Cards> deck;
    private static int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final Random randomNumbers = new Random();
    public static Cards[] temp;
    public static Cards faceDown;

    public Deck() {
        temp = new Cards[NUMBER_OF_CARDS];

        faceDown = new Cards("Face","Down");

        this.deck = new Stack<>();

        for(int i = 0; i < 13; i++) {
            Values values = Values.values()[i];
            for(int j = 0; j < 4; j++) {
                Suits suits = Suits.values()[j];
                Cards card = new Cards(values, suits);
                this.deck.add(card);
            }
        }
    }
    public void shuffle() {
        currentCard = 0;
        for(int i = 0; i < deck.size(); i++) {
            int j = randomNumbers.nextInt(NUMBER_OF_CARDS); //random from 0 - 52;
            temp[0] = deck.get(i); //temp is empty, deck[i] has ace of spades, right now temp also has ace of spades
            deck.set(i,deck.get(j)); //deck[i] has ace of spades, deck[j] has king of clubs, deck[i] also has king of clubs
            deck.set(j,temp[0]); //temp has ace of spades, deck[j] has king of clubs, deck[j] also has ace of spades
        }
    }
    public Cards[] dealCard(int cardDealt) {
        Cards[] dealt = new Cards[cardDealt];
        for (int i = 0; i < cardDealt; i++) {
            if (currentCard < deck.size()) {
                dealt[i] = deck.get(i);
                currentCard++;

            } else {
                return null;
            }
        }
        return dealt;
    }
    public Cards[] dealCardFaceDown(int cardDealt) {
        Cards[] result = dealCard(cardDealt);
        Cards[] dealt = new Cards[cardDealt];
        for(int i = 0; i < result.length; i++) {
            dealt[i] = result[i];
        }
        for(int i = 0; i < dealt.length; i++) {
            temp[i] = dealt[i];
            dealt[i] = faceDown;
        }
        return dealt;
    }
    public Cards reveal(int cardIndex, boolean flip) {
        if(flip = true) {
            return temp[cardIndex];
        } else {
            return faceDown;
        }
    }
}
