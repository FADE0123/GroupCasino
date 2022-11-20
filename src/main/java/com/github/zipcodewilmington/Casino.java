package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.*;
import com.github.zipcodewilmington.casino.players.*;
import com.github.zipcodewilmington.utils.*;
import javax.sound.sampled.*;
import java.io.IOException;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    CasinoAccount casinoAccount;
    private final IOConsole console = new IOConsole(AnsiColor.GREEN);
    private final IOConsole exit = new IOConsole(AnsiColor.RED);
    public String accountName;
    public String accountPassword;
    boolean isValidLogin;
    CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
    @Override
    public void run() {
        String arcadeDashBoardInput;
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            //MENU OPTION 1
            if ("1".equals(arcadeDashBoardInput) || "load account".equalsIgnoreCase(arcadeDashBoardInput)) {
                try {
                    casinoAccountManager.accountLoader();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            //MENU OPTION 2
            } else if ("2".equals(arcadeDashBoardInput) || "save account".equalsIgnoreCase(arcadeDashBoardInput)) {
                try {
                    casinoAccountManager.accountSaver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            //MENU OPTION 3
            } else if ("3".equals(arcadeDashBoardInput) || "get balance".equalsIgnoreCase(arcadeDashBoardInput)) {
                System.out.println("Your balance is " + CasinoAccountManager.casinoAccountList.get(0).getAccountBalance());
            //MENU OPTION 4
            } else if ("4".equals(arcadeDashBoardInput) || "select game".equalsIgnoreCase(arcadeDashBoardInput)) {
                this.casinoAccount = CasinoAccountManager.casinoAccountList.get(0);
                accountPassword = console.getStringInput("To make sure you're not too drunk, please enter your account password:");
                securityCheck(accountPassword);
                if (isValidLogin) {
                    while (true) {
                        int gameSelectionInput = Integer.parseInt(getGameSelectionInput());
                        switch (gameSelectionInput) {
                            case 1:
                                if (casinoAccount.accountBalance > 0) {
                                    play(new WarGame(), new WarPlayer());
                                    break;
                                } else {
                                    exit.println("WITH WHAT MONEY??? BYE FELICIA!");
                                    System.exit(1);
                                }
                            case 2:
                                if (casinoAccount.accountBalance > 0) {
                                    play(new BlackjackGame(), new BlackjackPlayer());
                                    break;
                                } else {
                                    exit.println("LEAVE!");
                                    System.exit(1);
                                }
                            case 3:
                                if (casinoAccount.accountBalance > 0) {
                                    play(new SlotsGame(), new SlotsPlayer());
                                    break;
                                } else {
                                    exit.println("TAKE YOUR BROKE ### HOME!");
                                    System.exit(1);
                                }
                            case 4:
                                if (casinoAccount.accountBalance > 0) {
                                    play(new RouletteGame(), new RoulettePlayer());
                                    break;
                                } else {
                                    exit.println("YOU ARE LITERALLY PENNILESS, NO PENNY SLOTS");
                                    System.exit(1);
                                }
                            case 5:
                                play(new RPSLSGame(), new RPSLSplayer());
                                break;
                            case 6:
                                play(new HighLowGame(), new HighLowPlayer());
                                break;
                            case 7:
                                Casino casino = new Casino();
                                casino.run();
                                break;
                            case 8:
                                console.println("Thank you for your money!");
                                System.exit(1);
                            default:
                                exit.println("Option does not exist, are you drunk???");
                                casinoAccount.securityPacket();
                                // TODO - implement better exception handling
                                String errorMessage = "IMPOSTER! [ %s ] AND PASSWORD OF [ %s ] DOES NOT EXIST! SECURITY!!!";
                                throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                        }
                    }
                }
            //MENU OPTION 5
            } else if ("5".equals(arcadeDashBoardInput) || "add balance from atm".equalsIgnoreCase(arcadeDashBoardInput)) {
                this.casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                accountPassword = console.getStringInput("To make sure you're not too drunk, please enter your account password:");
                securityCheck(accountPassword);
                if (isValidLogin) {
                    try {
                        casinoAccount.addMoneyFromATM();
                    } catch (UnsupportedAudioFileException e) {
                        throw new RuntimeException(e);
                    } catch (LineUnavailableException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            //MENU OPTION 6
            } else if ("6".equals(arcadeDashBoardInput) || "create account".equalsIgnoreCase(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                accountName = console.getStringInput("Enter your account name:");
                accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            //MENU OPTION 7
            } else if ("7".equals(arcadeDashBoardInput) || "exit casino".equalsIgnoreCase(arcadeDashBoardInput)) {
                console.println("Thank you for your money!");
                System.exit(1);
            }
        }
            while (!"logout".equals(arcadeDashBoardInput)) ;
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the F.A.D.E. Casino!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1: LOAD ACCOUNT ], [ 2: SAVE ACCOUNT ], [ 3: GET BALANCE ], [ 4: SELECT GAME ]")
                .append("\n\t[ 5: ADD BALANCE ], [ 6: CREATE NEW ACCOUNT ], [ 7: EXIT CASINO ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("Your current balance is " + casinoAccount.getAccountBalance())
                .append("\nFrom here, you can select any of the following options:")
                .append("\n    BETTING GAME [ 1:  WAR  ], [ 2:  BLACKJACK  ], [ 3:   SLOTS   ], [  4:  ROULETTE  ]")
                .append("\nNON-BETTING GAME [ 5: RPSLS ], [ 6:  HIGH  LOW  ], [ 7: MAIN MENU ], [ 8: EXIT CASINO ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }

    private boolean securityCheck(String accountPassword) {
        int i = 0;
        while(i < 3) {
            if (accountPassword.equals(this.casinoAccount.getAccountPassword())) {
                break;
            } else {
                accountPassword = console.getStringInput("YOU HAVE THE WRONG PASSWORD, TRY AGAIN!");
                casinoAccount.securityPacket();
                i++;
            }
        }
        isValidLogin = this.accountPassword.equals(this.casinoAccount.getAccountPassword());
        return isValidLogin;
    }
}
