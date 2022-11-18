package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Deck;
import com.github.zipcodewilmington.casino.players.WarPlayer;

import java.util.Scanner;

public class WarGame {
    int total = 500;
    Scanner scanner = new Scanner(System.in);
    int bet;
    char response = 'y';
    Deck deck = new Deck();

    WarPlayer player = new WarPlayer();
    WarPlayer dealer = new WarPlayer();
    public WarGame() {
        while (response == 'y' || response == 'Y' && total <= 0) {
            player.emptyHand();
            dealer.emptyHand();
            System.out.println("Welcome to War. Please enter your bet");
            bet = scanner.nextInt();
            scanner.nextLine();
            deck.shuffle();
            player.draw(deck.dealCard());
            player.playerCardReveal(true);
            int playerSum = player.getHandSum();
            dealer.draw(deck.dealCard());
            dealer.dealerCardReveal(true);
            int dealerSum = dealer.getHandSum();

            if (playerSum > dealerSum) {
                System.out.println("Player wins! Would you like to play again? Y/N");
                response = scanner.next().charAt(0);
            } else {
                System.out.println("Dealer wins! Would you like to play again? Y/N");
                response = scanner.next().charAt(0);
            }
        }
    }
}
