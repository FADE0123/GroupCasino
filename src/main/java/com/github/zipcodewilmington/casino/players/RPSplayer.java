package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RPSplayer implements PlayerInterface {

    String name;

    public RPSplayer(String name) {
        this.name = name;
    }

    public RPSplayer() {
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
