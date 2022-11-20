package com.github.zipcodewilmington.casino;

import java.io.*;
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
            if (accountName.equals(casinoAccount.getAccountName())
                    && accountPassword.equals(casinoAccount.getAccountPassword())) {
                return casinoAccount;
            }
        }
        return null;
    }

    public CasinoAccount createAccount(String accountName, String accountPassword) {

        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword);
        registerAccount(newAccount);
        return newAccount;
    }

    public CasinoAccount loadAccount(String accountName, String accountPassword, int accountBalance) {

        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword, accountBalance);
        registerAccount(newAccount);
        return newAccount;
    }

    public List<CasinoAccount> registerAccount(CasinoAccount newAccount) {
        this.casinoAccountList.add(newAccount);
        return this.casinoAccountList;
    }

    public void accountSaver() throws IOException {
        String line = "";
        CasinoAccount account;
        BufferedWriter save = new BufferedWriter(new FileWriter("AccountSave.txt"));
        account = casinoAccountList.get(0);
        String id = account.getAccountName();
        String pass = account.getAccountPassword();
        int balance = account.getAccountBalance();
        save.write(String.format("%s,%s,%s\n", id, pass, balance));
        System.out.println("Saved");
        save.close();
    }

    public void accountLoader() throws IOException {
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader("AccountSave.txt"));
        while ((line = reader.readLine()) != null) {
            String[] separate = line.split(",");
            String id = separate[0];
            String pass = separate[1];
            int balance = Integer.parseInt(separate[2]);
            loadAccount(id, pass, balance);
            System.out.println("Account has been recovered");
        }
    }
}
