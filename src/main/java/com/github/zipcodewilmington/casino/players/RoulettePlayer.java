package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.RouletteGame;

/**
 * Created by leon on 7/21/2020.
 */
public class RoulettePlayer extends Player {
    CasinoAccount account;
    RouletteGame rouletteGame;

    public RoulettePlayer() {
        getArcadeAccount();
    }

    public RoulettePlayer(String name, String password) {
        super.setAccountName(name);
        super.setAccountPassword(password);
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return account = CasinoAccountManager.casinoAccountList.get(0);
    }

    @Override
    public <RouletteGame> RouletteGame play() {
        return (RouletteGame) rouletteGame;
    }

}