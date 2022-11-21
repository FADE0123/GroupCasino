package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class HighLowPlayer extends Player {
    CasinoAccount account;
    HighLowPlayer highLowPlayer;

    public HighLowPlayer() {
        getArcadeAccount();
    }
    public HighLowPlayer(String name, String password) {
        super.setAccountName(name);
        super.setAccountPassword(password);
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return account = CasinoAccountManager.casinoAccountList.get(0);
    }

    @Override
    public <RPSLSplayer> RPSLSplayer play() {
        return (RPSLSplayer) highLowPlayer;
    }

}