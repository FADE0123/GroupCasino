package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RPSLSGame;
import com.github.zipcodewilmington.casino.games.SlotsGame;

public class RPSLSplayer extends Player {
    CasinoAccount account;
    RPSLSGame rpslsGame;

    public RPSLSplayer() {
        getArcadeAccount();
    }
    public RPSLSplayer(String name, String password) {
        super.setAccountName(name);
        super.setAccountPassword(password);
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return account = CasinoAccountManager.casinoAccountList.get(0);
    }

    @Override
    public <RPSLSGame> RPSLSGame play() {
        return (RPSLSGame) rpslsGame;
    }

}