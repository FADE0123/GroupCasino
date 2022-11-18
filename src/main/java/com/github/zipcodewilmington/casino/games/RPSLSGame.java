package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.players.RPSLSplayer;

import java.util.Random;
import java.util.Scanner;

public class RPSLSGame implements GameInterface {
    RPSLSplayer player;
    String playAgain;
    boolean response;
    Scanner scanner = new Scanner(System.in);

    public RPSLSGame() {
        add(this.player);
        run();
        System.out.println("\n");
        Casino casino = new Casino();
        casino.run();
    }

    @Override
    public void add(PlayerInterface player) {
        this.player = new RPSLSplayer("Player");
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        while (true) {
            String[] rpsls = {"rock", "paper", "scissors", "lizard", "spock"};
            String computerMove = rpsls[new Random().nextInt(rpsls.length)];

            String playerMove;

            while (true) {
                System.out.println("Please choose your options:\n" +
                        "[ROCK] [PAPER] [SCISSORS] [LIZARD] [SPOCK]");
                playerMove = scanner.nextLine();
                while (!playerMove.equalsIgnoreCase("rock") && !playerMove.equalsIgnoreCase("paper") && !playerMove.equalsIgnoreCase("scissors") && !playerMove.equalsIgnoreCase("lizard") && !playerMove.equalsIgnoreCase("spock")) {
                    System.out.println(playerMove + " error.");
                    playerMove = scanner.nextLine();
                    if (playerMove.equalsIgnoreCase("rock") || playerMove.equalsIgnoreCase("paper") || playerMove.equalsIgnoreCase("scissors") || playerMove.equalsIgnoreCase("lizard") || playerMove.equalsIgnoreCase("spock")) {
                        break;
                    }
                }

                System.out.println("Computer played: " + computerMove);

                if (playerMove.equalsIgnoreCase(computerMove)) {
                    System.out.println("It's a tie!");
                } else if (playerMove.equalsIgnoreCase("rock") &&
                        computerMove.equalsIgnoreCase("paper")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("paper") &&
                        computerMove.equalsIgnoreCase("scissors")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("scissors") &&
                        computerMove.equalsIgnoreCase("spock")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("spock") &&
                        computerMove.equalsIgnoreCase("lizard")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("lizard") &&
                        computerMove.equalsIgnoreCase("scissors")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("scissors") &&
                        computerMove.equalsIgnoreCase("rock")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("rock") &&
                        computerMove.equalsIgnoreCase("spock")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("spock") &&
                        computerMove.equalsIgnoreCase("paper")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("paper") &&
                        computerMove.equalsIgnoreCase("lizard")) {
                    System.out.println("You lose!");
                } else if (playerMove.equalsIgnoreCase("lizard") &&
                        computerMove.equalsIgnoreCase("rock")) {
                    System.out.println("You lose!");
                } else {
                    System.out.println("You win!");
                }
                System.out.println("Play again? (y/n)");
                playAgain = scanner.nextLine();
                if (!playAgain.equalsIgnoreCase("y")) {
                    break;
                }
            }
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }

        }
    }
}
//}