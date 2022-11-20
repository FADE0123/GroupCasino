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
    public CasinoAccount loadAccount(String accountName, String accountPassword, int accountBalance) {

        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword, accountBalance);
        registerAccount(newAccount);
        return newAccount;
    }
    public List<CasinoAccount> registerAccount (CasinoAccount newAccount) {
        this.casinoAccountList.add(newAccount);
        return this.casinoAccountList;
    }
    public void accountSaver() throws IOException {
        String line = "";
        CasinoAccount account;
        BufferedWriter save = new BufferedWriter(new FileWriter("AccountSave.txt", true));
        BufferedReader reader = new BufferedReader((new FileReader("AccountSave.txt")));
        while((line = reader.readLine()) != null) {
            for(int i = 0; i < casinoAccountList.size(); i++) {
                account = casinoAccountList.get(i);
                String id = account.getAccountName();
                String pass = account.getAccountPassword();
                int balance = account.getAccountBalance();
                save.write(String.format("%s,%s,%s\n",id,pass,balance));
                System.out.println("Saved");
            }
        }
        save.close();
    }
    public void accountLoader() {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("AccountSave.txt"));
            while((line = reader.readLine()) != null) {
                String[] separate = line.split(",");
                for (int i = 0; i < separate.length/3; i++) {
                    String id = separate[0];
                    String pass = separate[1];
                    int balance = Integer.parseInt(separate[2]);
                    loadAccount(id, pass, balance);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
