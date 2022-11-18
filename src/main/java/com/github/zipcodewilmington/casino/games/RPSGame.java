package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.players.RPSplayer;

import java.util.Random;
import java.util.Scanner;

public class RPSGame {
        public static final String ROCK = "rock";
        public static final String PAPER = "paper";
        public static final String SCISSOR = "scissor";

        public static String handSign = "";

        CasinoAccount player;

        public String getWinningMove (String handSign){
            if (handSign.equals(ROCK)) {
                return PAPER;
            } else if (handSign.equals(PAPER)) {
                return SCISSOR;
            } else if (handSign.equals(SCISSOR)) {
                return ROCK;
            }
            return null;
        }

        public String getLosingMove (String handSign){
            if (handSign.equals(ROCK)) {
                return SCISSOR;
            } else if (handSign.equals(PAPER)) {
                return ROCK;
            } else if (handSign.equals(SCISSOR)) {
                return PAPER;
            }
            return null;
        }

        public String playerSelection () {
            System.out.println("Choose your symbol");
            Scanner scanner = new Scanner(System.in);
            String playerSelect = scanner.nextLine();
            return playerSelect;
        }

        public String dealerSelect () {
            int dealerChoice = RandomNumberGenerator.randomizedNumber(2);
            switch (dealerChoice) {
                case 0:
                    handSign.equals(PAPER);
                    break;
                case 1:
                    handSign.equals(ROCK);
                    break;
                case 2:
                    handSign.equals(SCISSOR);
                    break;
                default:
            }
            return null;
        }

        public String getWinner (String playerSelect, String dealerSelect){
            if (getWinningMove(playerSelect).equals(getLosingMove(dealerSelect))) {
                return playerSelect;
            } else {
                return dealerSelect;
            }
        }
}
