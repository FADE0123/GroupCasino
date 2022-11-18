package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RPSLSplayer implements PlayerInterface {

    String name;

    public RPSLSplayer(String name) {
        this.name = name;
    }

    public RPSLSplayer() {
        getArcadeAccount();
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        CasinoAccount name = new CasinoAccount();
        name.getAccountName();
        return name;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return play();
    }
}
