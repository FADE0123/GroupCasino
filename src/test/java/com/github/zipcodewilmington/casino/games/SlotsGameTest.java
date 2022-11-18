package com.github.zipcodewilmington.casino.games;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class SlotsGameTest {
    @Test
    void isInFavorOfAll3() {
        //given
        int expected = [1, 1, 1];
        //when
        int actual = new int[1, 1, 1];
        //then
        Assert.assertEquals(expected, actual);

    }
}
