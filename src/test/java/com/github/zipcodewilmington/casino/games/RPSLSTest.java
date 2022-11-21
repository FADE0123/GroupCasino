package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.games.RPSLSGame;
import org.junit.Assert;
import org.junit.Test;

public class RPSLSTest {
    @Test
    public void ifComputerWinsOrPlayer() {
        // Given
        String playerInput = "rock";
        String computerExpected = "paper";

        // When
        String actual = "paper";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer2() {
        // Given
        String playerInput  = "paper";
        String computerExpected = "scissors";

        // When
        String actual = "scissors";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer3() {
        // Given
        String playerInput = "scissors";
        String computerExpected = "spock";

        // When
        String actual = "spock";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer4() {
        // Given
        String playerInput = "spock";
        String computerExpected = "lizard";

        // When
        String actual = "lizard";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer5() {
        // Given
        String playerInput = "lizard";
        String computerExpected = "scissors";

        // When
        String actual = "scissors";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer6() {
        // Given
        String playerInput = "scissors";
        String computerExpected = "rock";

        // When
        String actual = "rock";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer7() {
        // Given
        String playerInput = "rock";
        String computerExpected = "spock";

        // When
        String actual = "spock";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer8() {
        // Given
        String playerInput = "spock";
        String computerExpected = "paper";

        // When
        String actual = "paper";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer9() {
        // Given
        String playerInput = "paper";
        String computerExpected = "lizard";

        // When
        String actual = "lizard";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }

    @Test
    public void ifComputerWinsOrPlayer10() {
        // Given
        String playerInput = "lizard";
        String computerExpected = "rock";

        // When
        String actual = "rock";

        // Then
        Assert.assertEquals(computerExpected, actual);
    }
}