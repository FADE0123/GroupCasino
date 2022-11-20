package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.players.RPSLSplayer;
import com.github.zipcodewilmington.casino.players.RoulettePlayer;

import java.util.Random;
import java.util.Scanner;

public class RPSLSGame implements GameInterface {
    RPSLSplayer player;
    String playAgain;
    Scanner scanner = new Scanner(System.in);

    public RPSLSGame() {
        player = new RPSLSplayer();
        run();
        Casino casino = new Casino();
        casino.run();
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        while (true) {
            String[] rpsls = {"rock", "paper", "scissors", "lizard", "spock", ";ja;dkja;wej;ak"};


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
                String computerMove = rpsls[new Random().nextInt(rpsls.length)];
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
                } else if (computerMove.equalsIgnoreCase(";ja;dkja;wej;ak")) {
                    System.out.println("You win, the computer is an idiot");
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