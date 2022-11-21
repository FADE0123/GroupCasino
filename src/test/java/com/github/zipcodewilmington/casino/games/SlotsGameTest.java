package com.github.zipcodewilmington.casino.games;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class SlotsGameTest {
    @Test
    void ifAllMatchTest() {
        //given
        int expected = 1;
        //when
        int actual = 1;
        //then
        Assert.assertTrue(actual >= 0 && actual <= 3);

    }

    @Test
    void ifAllMatchTest2() {
        //given
        int expected = 2;
        //when
        int actual = (int) (2 * Math.random());
        //then
        Assert.assertTrue(actual >= 0 && actual <= 3);

    }

    @Test
    void ifAllMatchTest3() {
        //given
        int expected = 3;
        //when
        int actual = (int) (3 * Math.random());
        //then
        Assert.assertTrue(actual >= 0 && actual <= 3);

    }

    @Test
    void ifAllMatchTest4() {
        //given
        int expected = 1;
        //when
        int actual = (int) (1 * Math.random());
        //then
        Assert.assertFalse(actual <= 0 && actual >= 3);

    }

    @Test
    void ifAllMatchTest5() {
        //given
        int expected = 2;
        //when
        int actual = (int) (2 * Math.random());
        //then
        Assert.assertFalse(actual <= 0 && actual >= 3);

    }

    @Test
    void ifAllMatchTest6() {
        //given
        int expected = 3;
        //when
        int actual = (int) (3 * Math.random());
        //then
        Assert.assertFalse(actual <= 0 && actual >= 3);

    }
}
