package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoAccountTest {

    @Test
    void getAccountName() {
        CasinoAccount bond = new CasinoAccount("James","007",1000000);
        assertEquals(bond.getAccountName(), "James");
    }

    @Test
    void getAccountPassword() {
        CasinoAccount bond = new CasinoAccount("Semaj","700",1);
        assertEquals(bond.getAccountPassword(), "700");
    }

    @Test
    void setAccountName() {
        CasinoAccount bond = new CasinoAccount("James","007",1000000);
        bond.setAccountName("Semaj");
        assertEquals(bond.getAccountName(), "Semaj");
    }

    @Test
    void setAccountPassword() {
        CasinoAccount bond = new CasinoAccount("James","007",1000000);
        bond.setAccountPassword("700");
        assertEquals(bond.getAccountPassword(), "700");
    }

    @Test
    void getAccountBalance() {
        CasinoAccount bond = new CasinoAccount("James","007",1000000);
        assertEquals(bond.getAccountBalance(), 1000000);
    }

    @Test
    void getSecurityLevel() {
        CasinoAccount hustler = new CasinoAccount("Suspicioso", "1337",777);
        assertEquals(hustler.getSecurityLevel(), 0);
    }

    @Test
    void addSecurityLevel() {
        CasinoAccount hustler = new CasinoAccount("Suspicioso", "1337",777);
        hustler.addSecurityLevel();
        assertEquals(hustler.getSecurityLevel(), 1);
    }

    @Test
    void addAccountBalance() {
        CasinoAccount mrKrabs = new CasinoAccount("Eugene", "$$$", 10000000);
        mrKrabs.addAccountBalance(1);
        assertEquals(mrKrabs.getAccountBalance(),10000001);
    }

    @Test
    void subtractAccountBalance() {
        CasinoAccount hustler = new CasinoAccount("Suspicioso", "1337",777);
        hustler.subtractAccountBalance(770);
        assertEquals(hustler.getAccountBalance(), 7);
    }
}