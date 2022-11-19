package com.github.zipcodewilmington.casino;
import java.io.*;
import com.github.zipcodewilmington.utils.*;
import javax.sound.sampled.*;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    Random random = new Random();
    int ranNum = random.nextInt(50)+10;
    Timer timer;
    TimerTask timerTask;
    private String accountName;
    private String accountPassword;
    public int accountBalance = 1000;
    public int securityLevel = 0;
    private final IOConsole console = new IOConsole(AnsiColor.RED);

    public CasinoAccount (String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
    }
    public CasinoAccount (String accountName, String accountPassword, int accountBalance) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;
    }

    public CasinoAccount() {

    }
    public String getAccountName() {
        return accountName;
    }
    public String getAccountPassword() {
        return accountPassword;
    }
    public int getAccountBalance() {
        return accountBalance;
    }
    public int getSecurityLevel() {
        return securityLevel;
    }
    public int addSecurityLevel() {
        return securityLevel++;
    }
    public void addAccountBalance(double amount) {
        accountBalance += amount;
    }
    public void addMoneyFromATM() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        // NOTES
        File file = new File("/Users/freddy/Projects/GroupCasino/src/main/java/com/github/zipcodewilmington/casino/Macarena.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        int amount = console.getIntegerInput("Enter how much you want to add, max of 1000. Beware, there's consequences!");
        while(amount > 1000) {
            amount = console.getIntegerInput("Don't be too greedy!");
            addSecurityLevel();
            kickedOutBySecurity();
        }
        console.println("Per 100 that you added equals 1 second of macarena that you have to perform until balance is added");
        int finalAmount = amount;
        int finalAmount1 = amount;
        timerTask = new TimerTask() {
            @Override
            public void run() {
                console.println("You have added " + finalAmount + " to your balance. Great dancing!");
                clip.stop();
                clip.close();
                accountBalance += finalAmount1;
            }
        };
        timer = new Timer();
        clip.start();
        timer.schedule(timerTask, amount*10);
    }
    public void subtractAccountBalance(int amount) {
        accountBalance -= amount;
    }
    public boolean checkAccountBalance(double amount) {
        if (accountBalance >= amount) return true;
        else return false;
    }
    public void kickedOutBySecurity() {
        System.out.println(ranNum);
        if (securityLevel == ranNum) {
            console.println("YOU HAVE BEEN ACTING VERY SUSPICIOUSLY AND THE SECURITY TEAM KICKS YOU OUT!");
            System.exit(1); //terminates the run
        }
    }
    public void securityPacket() {
        addSecurityLevel();
        kickedOutBySecurity();
    }
}
