package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighLowPlayerTest {
    HighLowPlayer player;

    @Test
    void getArcadeAccount1() {
        player = new HighLowPlayer("Player", "Pass");
        CasinoAccountManager.casinoAccountList.add(player);
        String expected = player.getArcadeAccount().getAccountName();
        assertEquals(player.getAccountName(), expected);
    }

    @Test
    void getArcadeAccount2() {
        player = new HighLowPlayer("Person", "Sapp");
        CasinoAccountManager.casinoAccountList.set(0, player);
        String expected = player.getAccountPassword();
        assertEquals(expected, player.getArcadeAccount().getAccountPassword());
    }

    @Test
    void getArcadeAccount3() {
        player = new HighLowPlayer("People", "Apps");
        CasinoAccountManager.casinoAccountList.set(0, player);
        int expected = player.getArcadeAccount().getAccountBalance();
        assertEquals(1000, expected);
    }

    @Test
    void getArcadeAccount4() {
        player = new HighLowPlayer("Human", "Pssa");
        CasinoAccountManager.casinoAccountList.set(0, player);
        player.addSecurityLevel();
        int expected = player.getArcadeAccount().addSecurityLevel();
        assertEquals(1, expected);
    }
    @Test
    void getArcadeAccount5() {
        player = new HighLowPlayer("Body", "Spaa");
        CasinoAccountManager.casinoAccountList.set(0, player);
        player.subtractAccountBalance(200);
        int expected = player.getArcadeAccount().getAccountBalance();
        assertEquals(800, expected);
    }
    @Test
    void getArcadeAccount6() {
        player = new HighLowPlayer("Cadaver", "Ppsa");
        CasinoAccountManager.casinoAccountList.set(0, player);
        player.addAccountBalance(200);
        int expected = player.getArcadeAccount().getAccountBalance();
        assertEquals(1200, expected);
    }
}