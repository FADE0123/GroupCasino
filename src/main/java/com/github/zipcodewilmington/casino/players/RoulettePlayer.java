package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class RoulettePlayer implements PlayerInterface {

    String name;

    public RoulettePlayer(String name) {
        this.name = name;
    }

    public RoulettePlayer() {
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