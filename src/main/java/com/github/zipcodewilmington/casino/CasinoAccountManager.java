package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager extends IOConsole {
    HashMap<String, CasinoAccount> accounts = new HashMap<>();

    public static List<CasinoAccount> casinoAccountList = new ArrayList<>();

    public CasinoAccount getAccount(String accountName, String accountPassword) {
        readFromFile();

        for (Map.Entry<String, CasinoAccount> stringCasinoAccountEntry : accounts.entrySet()) {
            CasinoAccount account = stringCasinoAccountEntry.getValue();
            if (accounts.containsKey(accountName) && accountPassword.equals(account.getAccountPassword())) {
                return account;
            }
        }
        return null;
    }

    public CasinoAccount createAccount(String accountName, String accountPassword) {
        return new CasinoAccount(accountName, accountPassword);
    }

    public void registerAccount(CasinoAccount casinoAccount) {
        readFromFile();
        accounts.put(casinoAccount.getAccountName(), casinoAccount);
        writeToFile();
    }

    public void writeToFile() {
        try (BufferedWriter bufferField = new BufferedWriter(new FileWriter("players.txt", false))) {
            for (Map.Entry<String, CasinoAccount> entry : accounts.entrySet()) {
                String name = entry.getKey();
                String password = accounts.get(entry.getKey()).getAccountPassword();
                int balance = accounts.get(entry.getKey()).getAccountBalance();
                bufferField.write(name + ":" + password + ":" + balance);
                bufferField.newLine();
            }
            bufferField.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFile() {
        try (BufferedReader br = new BufferedReader((new FileReader("players.txt")))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] split = str.split(":");
                String name = split[0];
                String password = split[1];
                int balance = Integer.parseInt(split[2]);
                accounts.put(name, new CasinoAccount(name, password, balance));
            }
        }catch (IOException e) {
         e.printStackTrace();
            }
        }
    }
