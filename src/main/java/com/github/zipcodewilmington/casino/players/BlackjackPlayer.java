package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.Cards;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.BlackjackGame;

public class BlackjackPlayer extends Player {
    private String name;
    private Cards[] hand = new Cards[5];
    private int numberCards;
    CasinoAccount account;
    BlackjackGame blackjackGame;

    public BlackjackPlayer(String name) {
        this.name = name;
        this.emptyHand();
    }
    public BlackjackPlayer() {
        getArcadeAccount();
    }
    public BlackjackPlayer(String name, String password) {
        super.setAccountName(name);
        super.setAccountPassword(password);
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
        int numberAces = 0;
        for(int i = 0; i < this.numberCards; i++) {
            if(this.hand[i].getNumber() == 1) {
                numberAces++;
                handSum += 11;
            } else if (this.hand[i].getNumber() > 10) {
                handSum += 10;
            } else {
                handSum += this.hand[i].getNumber();
            }
        }
        while(handSum > 21 && numberAces > 0) {
            handSum -= 10;
            numberAces--;
        }
        return handSum;
    }
    public void cardReveal (boolean showHands) {
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
    public int getNumberCards() {
        return numberCards;
    }
    public Cards getHand(int index) {
        return hand[index];
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return account = CasinoAccountManager.casinoAccountList.get(0);
    }

    @Override
    public <BlackjackGame> BlackjackGame play() {
        return (BlackjackGame) blackjackGame;
    }
}
