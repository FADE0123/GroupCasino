package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

public class HighLowGame implements GameInterface {
    public static final int LOW = 1;
    public static final int HIGH = 15;
    int generator = RandomNumberGenerator.randomizedNumber((15) + 1);
    int winningNumber;
    int winNum;

    String playerMove;

    public HighLowGame(){
        run();
        Casino casino = new Casino();
        casino.run();
    }

    @Override
    public void run() {
        playerInput();
        compareGeneratorNumToPlayerSelected();
    }

    public void playerInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your choices : 1 = Lower <= 7, 2= Higher >= 8 - 15" +
                ("\n Random number will be chosen between 1-15. Will it be higher or lower?"));
        playerMove = scanner.nextLine();
    }

    public int randomGenerationNumber() {
        int winningNumber = generator;
        return winningNumber;
    }

    public void compareGeneratorNumToPlayerSelected() {
        randomGenerationNumber();
        if (playerMove.equals(LOW)) {
            ifLow();
        } else if (playerMove.equals(HIGH)) {
            ifHigh();
        }
        System.out.println(randomGenerationNumber());
        if ((winNum < 1) || (winNum > 15)) {
            System.out.println("You win!");
        }
        else {
            System.out.println("You lose!");
        }
    }

    public int ifLow() {
        if (playerMove.equals(LOW)) {
            int winNum = winningNumber - 7;
            return winNum;
        }
        return 0;
    }

    public int ifHigh() {
        if (playerMove.equals(HIGH)) {
            int winNum = winningNumber + 8;
            return winNum;
        }
        return 0;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }


}
