package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

public class HighLowGame implements GameInterface {

    int generator = RandomNumberGenerator.randomizedNumber((15) + 1);
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    int playerMove;

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
        playerMove = console.getIntegerInput ("Welcome to High Low game! \nSelect your choices : 1 = numbers from 1-7, 2 = numbers from 8-15" +
                ("\nRandom number will be chosen between 1-15."));
    }

    public int randomGenerationNumber() {
        int winningNumber = generator;
        return winningNumber;
    }

    public void compareGeneratorNumToPlayerSelected() {
        //randomGenerationNumber();
        if (playerMove == 1 && randomGenerationNumber() <= 7 || playerMove == 2 && randomGenerationNumber() > 7) {
            // ifLow();
            System.out.println("You Win! Random number is: " + randomGenerationNumber() + ".");
        } else {
            System.out.println("You Lose! Random number is: " + randomGenerationNumber() + ".");
        }
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }


}
