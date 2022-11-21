package com.github.zipcodewilmington.casino.players;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RouletteGame;
import com.github.zipcodewilmington.casino.games.SlotsGame;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer extends Player{
    CasinoAccount account;
    SlotsGame slotsGame;

    public SlotsPlayer() {
        getArcadeAccount();
    }
    public SlotsPlayer(String name, String password) {
        super.setAccountName(name);
        super.setAccountPassword(password);
    }
    @Override
    public CasinoAccount getArcadeAccount() {
        return account = CasinoAccountManager.casinoAccountList.get(0);
    }

    @Override
    public <SlotsGame> SlotsGame play() {
        return (SlotsGame) slotsGame;
    }

}