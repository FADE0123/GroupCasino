package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.Cards;

public class BlackjackPlayer {
    private String name;
    private Cards[] hand = new Cards[10];
    private int numberCards;
    public BlackjackPlayer(String name) {
        this.name = name;
        this.emptyHand();
    }
    public void emptyHand() {
        for (int i = 0; i < 5; i++) {
            this.hand[i] = null;
        }
        this.numberCards = 0;
    }
    public boolean draw(Cards card) {
        if(this.numberCards == 5) {
            System.err.printf("%s's hand is at max;\n", this.name);
            System.exit(1);
        }
        this.hand[this.numberCards] = card;
        this.numberCards++;
        return(this.getHandSum() <= 21);
    }
    public int getHandSum() {
        int handSum = 0;
        int cardNumber;
        int numberAces = 0;
        for(int i = 0; i < this.numberCards; i++) {
            cardNumber = this.hand[i].getNumber();
            if(cardNumber == 1) {
                numberAces++;
                handSum += 11;
            } else if (cardNumber > 10) {
                handSum += 10;
            } else {
                handSum += cardNumber;
            }
        }
        while(handSum > 21 && numberAces > 0) {
            handSum -= 10;
            numberAces--;
        }
        return handSum;
    }
    public void handResult (boolean showHands) {
        System.out.printf("%s's cards:\n", this.name);
        for(int i = 0; i < this.numberCards; i++) {
            if(i == 0 && !showHands) {
                System.out.println((" [faceDown]"));
            } else {
                System.out.printf("  %s\n", this.hand[i].toString());
            }
        }
    }
    public String getname() {
        return name;
    }
}
