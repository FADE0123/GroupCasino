package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.players.BlackjackPlayer;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {

    @Test
    public void firstPlayerDrawTest() {
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
//        System.setIn(in);

        BlackjackPlayer player = new BlackjackPlayer("Sanji", "chef");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.add(player);
        assertEquals(game.firstPlayerDraw(), true);
//        System.setIn(sysInBackup);
    }

    @Test
    public void secondPlayerNameTest() {
        BlackjackPlayer player = new BlackjackPlayer("Zoro","sword");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        String expected = game.player2 = player.getAccountName();
        String actual = game.secondPlayerName().getname();
        assertEquals(expected, actual);
    }

    @Test
    public void thirdPlayerNameTest() {
        BlackjackPlayer player = new BlackjackPlayer("Luffy","rubber");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        String expected = game.player3 = player.getAccountName();
        String actual = game.thirdPlayerName().getname();
        assertEquals(expected, actual);
    }

    @Test
    public void fourthPlayerNameTest() {
        BlackjackPlayer player = new BlackjackPlayer("Usopp","sniper");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        String expected = game.player4 = player.getAccountName();
        String actual = game.fourthPlayerName().getname();
        assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerDrawTest() {
        BlackjackPlayer player = new BlackjackPlayer("Zoro", "sword");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.secondPlayer = player;
        assertEquals(game.secondPlayerDraw(), false);
    }

    @Test
    public void thirdPlayerDrawTest() {
        BlackjackPlayer player = new BlackjackPlayer("Luffy", "rubber");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.thirdPlayer = player;
        assertEquals(game.thirdPlayerDraw(), false);
    }
    @Test
    public void fourthPlayerDrawTest() {
        BlackjackPlayer player = new BlackjackPlayer("Usopp", "sniper");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.fourthPlayer = player;
        assertEquals(game.fourthPlayerDraw(), false);
    }
    @Test
    public void firstPersonHitOrStayTest() {
        BlackjackPlayer player = new BlackjackPlayer("Robin","flowers");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.add(player);
        assertEquals(game.firstPersonHitOrStay("H"), false);
    }
    @Test
    public void secondPersonHitOrStayTest() {
        BlackjackPlayer player = new BlackjackPlayer("Zoro","sword");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.player2 = player.getAccountName();
        game.secondPlayerName().getname();
        assertEquals(game.secondPersonHitOrStay("H"), false);
    }
    @Test
    public void thirdPersonHitOrStayTest() {
        BlackjackPlayer player = new BlackjackPlayer("Luffy","rubber");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.player3 = player.getAccountName();
        game.thirdPlayerName().getname();
        assertEquals(game.thirdPersonHitOrStay("S"), true);
    }
    @Test
    public void fourthpersonHitOrStayTest() {
        BlackjackPlayer player = new BlackjackPlayer("Usopp","sniper");
        CasinoAccountManager.casinoAccountList.add(player);
        BlackjackGame game = new BlackjackGame("Test");
        game.player4 = player.getAccountName();
        game.fourthPlayerName().getname();
        assertEquals(game.fourthPersonHitOrStay("S"), true);
    }
    @Test
    public void dealerHitOrStayTest() {
        BlackjackGame game = new BlackjackGame("Test");
        assertEquals(game.dealerHitOrStay(),false);
    }
}