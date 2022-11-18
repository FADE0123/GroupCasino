package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {

    public static List<CasinoAccount> casinoAccountList = new ArrayList<>();

    public CasinoAccount getAccount(String accountName, String accountPassword) {

        for (CasinoAccount casinoAccount : casinoAccountList) {
            if(accountName.equals(casinoAccount.getAccountName())
                && accountPassword.equals(casinoAccount.getAccountPassword())){
                return casinoAccount;
            }
            else {
                System.out.println("Invalid account. Please try again!");
            }
        }
        return null;
    }

    public CasinoAccount createAccount(String accountName, String accountPassword) {

        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword);
        registerAccount(newAccount);
        return newAccount;
    }
    public List<CasinoAccount> registerAccount (CasinoAccount newAccount) {
        this.casinoAccountList.add(newAccount);
        return this.casinoAccountList;
    }
}
