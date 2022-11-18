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
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
//                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please select a game");
                    System.out.println("[1 = Roulette] [2 = Blackjack] [3 = Card Memory] " +
                            "[4 = Go Fish] [5 = RPSLS] [6 = Slots] [7 = War]");

                    int userInput = scanner.nextInt();

                    switch(userInput){
                        case 1:
                            play(new RouletteGame(), new RoulettePlayer());
                            break;
                        case 2:
                            play(new BlackjackGame(), new BlackjackPlayer("Freddy"));
                            break;
                        case 3:
                            play(new CardMemoryGame(), new CardMemoryPlayer());
                            break;
                        case 4:
                            play(new GoFishGame(), new GoFishPlayer());
                            break;
                        case 5:
                            play(new RPSLSGame(), new RPSLSplayer());
                            break;
                        case 6:
                            play(new SlotsGame(), new SlotsPlayer());
                            break;
                        case 7:
                            play(new WarGame(), new WarPlayer());
                            break;
                        default:
                            System.out.println("Please Select a game");
                            break;
                        // TODO - implement better exception handling
                        //String errorMessage = "[ %s ] is an invalid game selection";
                        //throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create account ], [ select game ]")
                .toString());
    }

//    private String getGameSelectionInput() {
//        return console.getStringInput(new StringBuilder()
//                .append("Welcome to the Game Selection Dashboard!")
//                .append("\nFrom here, you can select any of the following options:")
//                .append("\n\t[ SLOTS ], [ GOFISH ], [ BLACKJACK ], [ CARD MEMORY ], [ WAR ], [ ROULETTE ], [ RPSLS ]")
//                .toString());
//    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
