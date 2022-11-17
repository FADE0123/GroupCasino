package com.github.zipcodewilmington.casino.games;

import java.util.List;

public class RPSLSGame {
    static final String ROCK = "rock";
    static final String PAPER = "paper";
    static final String SCISSORS = "scissors";
    static final String LIZARD = "lizard";
    static final String SPORK = "spork";

    public String getWinningMove(String handSign) {
        if (handSign.equals (ROCK)) {
            return handSign;
        }
        else if (handSign.equals(PAPER)) {
            return handSign;
        }
        else if (handSign.equals(SCISSORS)) {
            return handSign;
        }
        else if (handSign.equals(LIZARD)) {
            return handSign;
        }
        else if (handSign.equals(SPORK)) {
            return handSign;
        }
        return handSign;
    }

    public String getLosingMove(String handSign) {
        if (handSign.equals (ROCK)) {
            return handSign;
        }
        else if (handSign.equals(PAPER)) {
            return handSign;
        }
        else if (handSign.equals(SCISSORS)) {
            return handSign;
        }
        else if (handSign.equals(LIZARD)) {
            return handSign;
        }
        else if (handSign.equals(SPORK)) {
            return handSign;
        }
        return handSign;
    }

    public String getWinner(String RPSLSplayer, String RPSLSplayer2) {
        if (RPSLSplayer.equals(RPSLSplayer2)) {
            return null;
        }
        return getWinningMove(RPSLSplayer).equals(getLosingMove(RPSLSplayer2)) ? RPSLSplayer : RPSLSplayer2;
    }
}
