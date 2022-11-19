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
    String accountName = null;
    String accountPassword = null;
    boolean isValidLogin;
    CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
    @Override
    public void run() {
        String arcadeDashBoardInput;
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("2".equals(arcadeDashBoardInput)|| "select game".equalsIgnoreCase(arcadeDashBoardInput)) {
                this.casinoAccount = casinoAccountManager.getAccount(CasinoAccountManager.casinoAccountList.get(0).getAccountName(), CasinoAccountManager.casinoAccountList.get(0).getAccountPassword());
                accountPassword = console.getStringInput("To make sure you're not too drunk, please enter your account password:");
                securityCheck(accountPassword);
                if (isValidLogin) {
                    while(true) {
                        int gameSelectionInput = Integer.parseInt(getGameSelectionInput());
                        switch (gameSelectionInput) {
                            case 1:
                                if(casinoAccount.accountBalance > 0) {
                                    play(new WarGame(), new WarPlayer());
                                    break;
                                } else {
                                    exit.println("WITH WHAT MONEY??? BYE FELICIA!");
                                    System.exit(1);
                                }
                            case 2:
                                if(casinoAccount.accountBalance > 0) {
                                    play(new BlackjackGame(), new BlackjackPlayer());
                                    break;
                                } else {
                                    exit.println("LEAVE!");
                                    System.exit(1);
                                }
                            case 3:
                                play(new SlotsGame(), new SlotsPlayer());
                                break;
                            case 4:
                                if(casinoAccount.accountBalance > 0) {
                                    play(new RouletteGame(), new RoulettePlayer());
                                    break;
                                } else {
                                    exit.println("YOU ARE LITERALLY PENNILESS, NO PENNY SLOTS");
                                    System.exit(1);
                                }
                            case 5:
                                if(casinoAccount.accountBalance > 0) {
                                    play(new RPSLSGame(), new RPSLSplayer());
                                    break;
                                } else {
                                    exit.println("TIME TO GO!");
                                    System.exit(1);
                                }
                        case 6:
                            play(new HighLowGame(), new HighLowPlayer());
                            break;
//                        case 7:
//                            play(new GoFishGame(), new GoFishPlayer());
//                            break;
                            case 8:
                                console.println("Thank you for your money!");
                                System.exit(1);
                            default:
                                exit.println("Option does not exist, are you drunk???");
                                casinoAccount.securityPacket();
                                // TODO - implement better exception handling
//                                String errorMessage = "Option %s does not exist, are you drunk???";
//                            throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                        }
                    }
                }
//                else {
                    // TODO - implement better exception handling
                    String errorMessage = "IMPOSTER! [ %s ] AND PASSWORD OF [ %s ] DOES NOT EXIST! SECURITY!!!";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                } else if ("1".equals(arcadeDashBoardInput) || "create account".equalsIgnoreCase(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                accountName = console.getStringInput("Enter your account name:");
                accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            } if ("3".equals(arcadeDashBoardInput)|| "add balance from atm".equalsIgnoreCase(arcadeDashBoardInput)) {
                this.casinoAccount = casinoAccountManager.getAccount(CasinoAccountManager.casinoAccountList.get(0).getAccountName(), CasinoAccountManager.casinoAccountList.get(0).getAccountPassword());
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
            } else if ("4".equals(arcadeDashBoardInput) || "exit casino".equalsIgnoreCase(arcadeDashBoardInput)) {
                console.println("Thank you for your money!");
                System.exit(1);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the F.A.D.E. Casino!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ 1: CREATE ACCOUNT ], [ 2: SELECT GAME ], [ 3: ADD BALANCE FROM ATM ], [ 4: EXIT CASINO ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("Your current balance is " + casinoAccount.getAccountBalance())
                .append("\nFrom here, you can select any of the following options:")
                .append("\n    BETTING GAME [ 1:  WAR  ], [ 2:  BLACKJACK  ], [ 3:  SLOTS  ], [  4:  ROULETTE  ]")
                .append("\nNON-BETTING GAME [ 5: RPSLS ], [ 6:  HIGH  LOW  ], [ 8: EXIT CASINO ]")
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
