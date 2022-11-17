package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.RPSLSGame;
import org.junit.Assert;
import org.junit.Test;

public class RPSLSTest {
    @Test
    public void getWinningMoveTest() {
        //Given
        String input = "spork";
        String expected = "spork";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinningMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinningMoveTest2() {
        //Given
        String input = "rock";
        String expected = "rock";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinningMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinningMoveTest3() {
        //Given
        String input = "scissors";
        String expected = "scissors";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinningMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLosingMoveTest() {
        //Given
        String input = "spork";
        String expected = "spork";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getLosingMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLosingMoveTest2() {
        //Given
        String input = "paper";
        String expected = "paper";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getLosingMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLosingMoveTest3() {
        //Given
        String input = "spork";
        String expected = "spork";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getLosingMove(input);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getWinnerTest() {
        //Given
        String input1 = "lizard";
        String input2 = "scissors";
        String expected = "scissors";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinner(input1, input2);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinnerTest2() {
        //Given
        String input1 = "lizard";
        String input2 = "rock";
        String expected = "rock";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinner(input1, input2);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinnerTest3() {
        //Given
        String input1 = "lizard";
        String input2 = "spork";
        String expected = "spork";
        RPSLSGame rpsls = new RPSLSGame();
        //When
        String actual = rpsls.getWinner(input1, input2);
        //Then
        Assert.assertEquals(expected, actual);
    }

}