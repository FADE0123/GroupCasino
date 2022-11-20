package com.github.zipcodewilmington.casino.games;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.players.RoulettePlayer;
import com.github.zipcodewilmington.casino.players.SlotsPlayer;
import java.util.Scanner;
public class SlotsGame implements GameInterface {
    //take the randomNumberGenerator to generate number from the range of 1-3 with default starting at 1
    // scanner to help us read through the slots
    Scanner scanner = new Scanner(System.in);
    int total;
    String playAgain;
    char response;
    int slot1, slot2, slot3;
    CasinoAccount player;

    public SlotsGame() {
        player = CasinoAccountManager.casinoAccountList.get(0);
        run();
        Casino casino = new Casino();
        casino.run();
    }
    @Override
    public void run() {
        //these are going to be displayed in the beginning of the game and player will input bet amount
        System.out.println("Winning rules: If all 3 rows match, you win double, if you get 2 in a row to match, you win");
        System.out.println("How much do you want to bet? ");
        total = scanner.nextInt();
        //these are going to take the randomNumberGenerator to randomly put numbers in
        int generator = RandomNumberGenerator.randomizedNumber(10) + 1;
        slot1 = generator;
        int generator2 = RandomNumberGenerator.randomizedNumber(10) + 1;
        slot2 = generator2;
        int generator3 = RandomNumberGenerator.randomizedNumber(10) + 1;
        slot3 = generator3;
        //this will print out the random numbers for each row in the slot
        System.out.println(slot1 + " " + slot2 + " " + slot3 + " ");
        //if all 3 slots have same number, you win
        if (slot1 == slot2 && (slot1 == slot3)) {
            System.out.println("You win double");
            player.addAccountBalance(total*4);
            player.securityPacket();
            // if only 2 slots have same number, you win
        } else if (slot1 == slot2 || (slot1 == slot3) || (slot2 == slot3)) {
            System.out.println("You win");
            player.addAccountBalance(total*2);
            player.securityPacket();
        } else {
            // no matches
            System.out.println("You lose");
            player.subtractAccountBalance(total);
        }
        System.out.println("\n");
        Casino casino = new Casino();
        casino.run();
    }
    @Override
    public void add(PlayerInterface player) {
    }
    @Override
    public void remove(PlayerInterface player) {
    }
}