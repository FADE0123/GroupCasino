package com.github.zipcodewilmington.casino.players;

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
    @Override
    public CasinoAccount getArcadeAccount() {
        account = CasinoAccountManager.casinoAccountList.get(0);
        return account;
    }

    @Override
    public <RouletteGame> RouletteGame play() {
        return (RouletteGame) rouletteGame;
    }

}