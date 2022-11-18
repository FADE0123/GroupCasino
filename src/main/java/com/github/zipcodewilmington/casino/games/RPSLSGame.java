package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.players.RPSLSplayer;
import com.github.zipcodewilmington.casino.players.WarPlayer;

import java.util.Random;
import java.util.Scanner;

public class RPSLSGame implements GameInterface {
    RPSLSplayer player;
    Scanner scanner = new Scanner(System.in);
    public RPSLSGame() {
        add(this.player);
        run();
    }
    @Override
    public void add(PlayerInterface player) {
        this.player = new RPSLSplayer("Player");
    }

    @Override
    public void run() {
        while (true) {
            String[] rpsls = {"rock", "paper", "scissors", "lizard", "spock"};
            String computerMove = rpsls[new Random().nextInt(rpsls.length)];

            String playerMove;

            while (true) {
                System.out.println("Please choose your options (rock, paper, scissors, lizard, spock)");
                playerMove = scanner.nextLine();
                if (playerMove.equalsIgnoreCase("rock") || playerMove.equalsIgnoreCase("paper") || playerMove.equalsIgnoreCase("spock") || playerMove.equalsIgnoreCase("lizard") || playerMove.equalsIgnoreCase("spock")) {
                    break;
                }
                System.out.println(playerMove + " error.");
            }

            System.out.println("Computer played: " + computerMove);

            if (playerMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if (playerMove.equalsIgnoreCase("rock")) {
                if (computerMove.equalsIgnoreCase("paper")) {
                    System.out.println("You lose!");

                } else if (computerMove.equalsIgnoreCase("scissors")) {
                    System.out.println("You win!");
                }
            } else if (playerMove.equalsIgnoreCase("lizard")) {
                if (computerMove.equalsIgnoreCase("spock")) {
                    System.out.println("You win!");

                } else if (computerMove.equalsIgnoreCase("scissors")) {
                    System.out.println("You lose!");
                }
            } else if (playerMove.equalsIgnoreCase("lizard")) {
                if (computerMove.equalsIgnoreCase("paper")) {
                    System.out.println("You win!");

                } else if (computerMove.equalsIgnoreCase("rock")) {
                    System.out.println("You lose!");
                }
            }

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }
        scanner.close();
        System.out.println("\n");
        Casino casino = new Casino();
        casino.run();
    }



    @Override
    public void remove(PlayerInterface player) {

    }

}
//}