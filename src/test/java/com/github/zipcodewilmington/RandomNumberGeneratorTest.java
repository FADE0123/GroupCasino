package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;

public class RandomNumberGeneratorTest {

    @Test

    public void randomizedNumberTest() {


        //Given
        int upperBound = 9;

        //When
        int result = RandomNumberGenerator.randomizedNumber(upperBound);
        //Then
        Assert.assertTrue((result >= 0) && (result <= 8));

    }

    @Test
    public void randomizedNumberTest2() {
        //Given
        int upperBound = 38;

        //When
        int result = RandomNumberGenerator.randomizedNumber(upperBound);

        //Then
        Assert.assertTrue((result >= 0) && (result <= 37));
    }

}
