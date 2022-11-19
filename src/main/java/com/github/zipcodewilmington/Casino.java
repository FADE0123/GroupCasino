package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.*;
import com.github.zipcodewilmington.casino.players.*;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    public static CasinoAccount casinoAccount;
    private final IOConsole console = new IOConsole(AnsiColor.GREEN);

    String accountName;
    String accountPassword;

    @Override
    public void run() {
        String CasinoInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            CasinoInput = getCasinoInput();
            if ("1".equals(CasinoInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    while (!gameSelectionInput.equals("0")) {
                        if (gameSelectionInput.equals("1")) {
                            play(new BlackjackGame(), new BlackjackPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("2")) {
                            play(new HighLowGame(), new HighLowPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("3")) {
                            play(new RPSLSGame(), new RPSLSplayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("4")) {
                            play(new RouletteGame(), new RoulettePlayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("5")) {
                            play(new SlotsGame(), new SlotsPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("6")) {
                            play(new WarGame(), new WarPlayer());
                            gameSelectionInput = getGameSelectionInput();
                        } else if (gameSelectionInput.equals("7")) {
                            System.out.println("Have a good day!");
                            System.exit(1);
                        }
                    }
                    casinoAccountManager.writeToFile();
                } else {
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    System.out.println(errorMessage + "\n Try again");
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));

                }
            } else if ("2".equals(CasinoInput)) {
                console.println(" Please create an account");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput(("Enter your password:"));
                CasinoAccount newAcct = casinoAccountManager.createAccount(accountName,accountPassword);
                casinoAccountManager.registerAccount(newAcct);
            }
        } while (!"0".equals(CasinoInput));
    }

    private String getCasinoInput() {
        return console.getStringInput("Welcome to the F.A.D.E. Casino!" +
                "\nFrom here, you can select any of the following options:" +
                "\n\t [1. Login ], [2. Create Account ], [ 0. Exit ]");
    }

    private String getGameSelectionInput() {
        return console.getStringInput("Welcome to the Game Selection Dashboard!" +
                        "\n Your current balance is " + casinoAccount.getAccountBalance() +
                        "\nFrom here, you can select any of the following options:" +
                        "\n\t[ 1: BLACKJACK ], [ 2: HIGH LOW ], [ 3: RPSLS ], [ 4: ROULETTE ], [ 5: SLOTS ], [ 6: WAR ], [ 7: EXIT CASINO ]");
    }

    private void play (Object gameObject, Object playerObject){
        GameInterface game = (GameInterface) gameObject;
        PlayerInterface player = (PlayerInterface) playerObject;
        game.add(player);
        game.run();
    }
}






            /*
//            if ("2".equals(arcadeDashBoardInput)|| "select game".equalsIgnoreCase(arcadeDashBoardInput)) {
//                String accountName = console.getStringInput("Enter your account name:");
//                String accountPassword = console.getStringInput("Enter your account password:");
//                this.casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
//                boolean isValidLogin = this.casinoAccount != null;
//                if (isValidLogin) {
//                    int gameSelectionInput = Integer.parseInt(getGameSelectionInput());
//                    switch(gameSelectionInput){
//                        case 1:
//                            play(new RouletteGame(), new RoulettePlayer());
//                            break;
//                        case 2:
//                            play(new BlackjackGame(), new BlackjackPlayer());
//                            break;
//                        case 3:
//                            play(new RPSLSGame(), new RPSLSplayer());
//                            break;
//                        case 4:
//                            play(new SlotsGame(), new SlotsPlayer());
//                            break;
//                        case 5:
//                            play(new WarGame(), new WarPlayer());
//                            break;
////                        case 6:
////                            play(new CardMemoryGame(), new CardMemoryPlayer());
////                            break;
////                        case 7:
////                            play(new GoFishGame(), new GoFishPlayer());
////                            break;
//                        case 8:
//                            console.println("Have a good day!");
//                            System.exit(1);
//                        default:
//                            // TODO - implement better exception handling
//                            String errorMessage = "[ %s ] is an invalid game selection";
//                            throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
//                    }
//                } else {
//                    // TODO - implement better exception handling
//                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
//                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
//                }
//            } else if ("1".equals(arcadeDashBoardInput) || "create account".equalsIgnoreCase(arcadeDashBoardInput)) {
//                console.println("Welcome to the account-creation screen.");
//                String accountName = console.getStringInput("Enter your account name:");
//                String accountPassword = console.getStringInput("Enter your account password:");
//                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
//                casinoAccountManager.registerAccount(newAccount);
//            } else if ("3".equals(arcadeDashBoardInput) || "exit casino".equalsIgnoreCase(arcadeDashBoardInput)) {
//                console.println("Have a good day!");
//                System.exit(1);
//            }
//        } while (!"logout".equals(arcadeDashBoardInput));
//    }

//            () {
            private String getCasinoInput() {
               return console.getStringInput(new StringBuilder()
                        .append("Welcome to the F.A.D.E. Casino!")
                        .append("\nFrom here, you can select any of the following options:")
                        .append("\n\t[ 1: CREATE ACCOUNT ], [ 2: SELECT GAME ], [ 3: EXIT CASINO ]")
                        .toString());
            }

            private String getGameSelectionInput () {
                return console.getStringInput(new StringBuilder()
                        .append("Welcome to the Game Selection Dashboard!")
                        .append("Your current balance is " + casinoAccount.getAccountBalance())
                        .append("\nFrom here, you can select any of the following options:")
                        .append("\n\t[ 1: ROULETTE ], [ 2: BLACKJACK ], [ 3: RPSLS ], [ 4: SLOTS ], [ 5: WAR ], [ 6: CARD MEMORY ], [ 7: GO FISH ], [ 8: EXIT CASINO ]")
                        .toString());
            }

            private void play (Object gameObject, Object playerObject){
                GameInterface game = (GameInterface) gameObject;
                PlayerInterface player = (PlayerInterface) playerObject;
                game.add(player);
                game.run();
            }
        }
 */