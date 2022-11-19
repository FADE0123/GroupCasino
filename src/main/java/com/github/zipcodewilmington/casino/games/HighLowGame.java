package com.github.zipcodewilmington.casino.games;

import java.util.Scanner;

public class HighLowGame {
    public static final int LOW = 1;
    public static final int HIGH = 15;
    int generator = RandomNumberGenerator.randomizedNumber((15) + 1);
    int winningNumber;
    int winNum;

    String playerMove;

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
        if (playerMove.equals(LOW)) {
            ifLow();
        } else if (playerMove.equals(HIGH)) {
            ifHigh();
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
}
