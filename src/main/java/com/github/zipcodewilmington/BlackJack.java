package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.players.BlackjackPlayer;

import java.util.Scanner;

public class BlackJack extends Deck {
        Scanner scanner = new Scanner(System.in);
        Deck BJDeck = new Deck(1, true);
        BlackjackPlayer firstPlayer;
        BlackjackPlayer secondPlayer = new BlackjackPlayer(null);
        BlackjackPlayer thirdPlayer = new BlackjackPlayer(null);
        BlackjackPlayer fourthPlayer = new BlackjackPlayer(null);
        BlackjackPlayer dealer = new BlackjackPlayer("Dealer");
        boolean firstPlayerDone = false;
        boolean secondPlayerDone = false;
        boolean thirdPlayerDone = false;
        boolean fourthPlayerDone = false;
        boolean dealerDone = false;
        boolean toggle = false;
        public BlackJack() {
            System.out.println("Welcome to BlackJack. Please enter up to 4 players");
            System.out.println("Please enter player 1.");
            String player1 = scanner.nextLine();
            while(true) {
                firstPlayer = new BlackjackPlayer(player1);
                System.out.println("Please enter player 2. Leave empty for 1 player game");
                String player2 = scanner.nextLine();
                if (player2 == "") {
                    startGame();
                    break;
                } else {
                    secondPlayer = new BlackjackPlayer(player2);
                }
                System.out.println("Please enter player 3. Leave empty for 2 player game");
                String player3 = scanner.nextLine();
                if (player3 == "") {
                    startGame();
                    break;
                } else {
                    thirdPlayer = new BlackjackPlayer(player3);
                }
                System.out.println("Please enter player 4. Leave empty for 3 player game");
                String player4 = scanner.nextLine();
                if (player4 == "") {
                    startGame();
                    break;
                } else {
                    fourthPlayer = new BlackjackPlayer(player4);
                    break;
                }
            }
            if(!toggle) {
                startGame();
            }
        }
        public void startGame() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 1; j++) {
                    firstPlayer.draw(BJDeck.dealCard());
                    dealer.draw(BJDeck.dealCard());
                    if (secondPlayer.getname() == null) {
                        break;
                    } else {
                        secondPlayer.draw((BJDeck.dealCard()));
                    }
                    if (thirdPlayer.getname() == null) {
                        break;
                    } else {
                        thirdPlayer.draw(BJDeck.dealCard());
                    }
                    if (fourthPlayer.getname() == null) {
                        break;
                    } else {
                        fourthPlayer.draw(BJDeck.dealCard());
                    }
                }
            }
            firstPlayer.handResult(true);
            System.out.print("\n");
            secondPlayer.handResult(true);
            System.out.print("\n");
            thirdPlayer.handResult(true);
            System.out.print("\n");
            fourthPlayer.handResult(true);
            System.out.print("\n");
            dealer.handResult(false);
            System.out.println("\nCards are dealt\n");

            String response;
            while(!firstPlayerDone) {
                System.out.println(firstPlayer.getname() + ": Hit Me [H] or Stay [S]:");
                response = scanner.nextLine();
                if(response.compareToIgnoreCase("H") == 0) {
                    firstPlayerDone = !firstPlayer.draw(BJDeck.dealCard());
                    firstPlayer.handResult(true);
                } else if (response.compareToIgnoreCase("S") == 0) {
                    firstPlayerDone = true;
                }
            }
            while(!secondPlayerDone) {
                if (secondPlayer.getname() == null) {
                    break;
                } else if (!secondPlayerDone) {
                    System.out.println(secondPlayer.getname() + ": Hit Me [H] or Stay [S]:");
                    response = scanner.nextLine();
                    if (response.compareToIgnoreCase("H") == 0) {
                        secondPlayerDone = !secondPlayer.draw(BJDeck.dealCard());
                        secondPlayer.handResult(true);
                    } else if (response.compareToIgnoreCase("S") == 0) {
                        secondPlayerDone = true;
                    }
                }
            }
            while(!thirdPlayerDone) {
                if (thirdPlayer.getname() == null) {
                    break;
                } else if (!thirdPlayerDone) {
                    System.out.println(thirdPlayer.getname() + ": Hit Me [H] or Stay [S]:");
                    response = scanner.nextLine();
                    if (response.compareToIgnoreCase("H") == 0) {
                        thirdPlayerDone = !thirdPlayer.draw(BJDeck.dealCard());
                        thirdPlayer.handResult(true);
                    } else if (response.compareToIgnoreCase("S") == 0) {
                        thirdPlayerDone = true;
                    }
                }
            }
            while(!fourthPlayerDone) {
                if (fourthPlayer.getname() == null) {
                    break;
                } else if (!fourthPlayerDone) {
                    System.out.println(fourthPlayer.getname() + ": Hit Me [H] or Stay [S]:");
                    response = scanner.nextLine();
                    if (response.compareToIgnoreCase("H") == 0) {
                        fourthPlayerDone = !fourthPlayer.draw(BJDeck.dealCard());
                        fourthPlayer.handResult(true);
                    } else if (response.compareToIgnoreCase("S") == 0) {
                        fourthPlayerDone = true;
                    }
                }
            }
            while(!dealerDone) {
                if (dealer.getHandSum() < 17) {
                    System.out.println("Dealer hits\n");
                    dealerDone = !dealer.draw(BJDeck.dealCard());
                    dealer.handResult(false);
                } else {
                    System.out.println("Dealer stays\n");
                    dealerDone = true;
                }
            }

            firstPlayer.handResult(true);
            System.out.print("\n");
            secondPlayer.handResult(true);
            System.out.print("\n");
            thirdPlayer.handResult(true);
            System.out.print("\n");
            fourthPlayer.handResult(true);
            System.out.print("\n");
            dealer.handResult(true);
            System.out.print("\n");

            int playerOneSum = firstPlayer.getHandSum();
            int playerTwoSum = secondPlayer.getHandSum();
            int playerThreeSum = thirdPlayer.getHandSum();
            int playerFourSum = fourthPlayer.getHandSum();
            int dealerSum = dealer.getHandSum();

            if(playerOneSum > dealerSum &&
                    playerOneSum > playerTwoSum &&
                    playerOneSum > playerThreeSum &&
                    playerOneSum > playerFourSum &&
                    playerOneSum <= 21 || dealerSum > 21) {
                System.out.println(firstPlayer.getname() + " wins!");
            } else if(playerTwoSum > dealerSum &&
                    playerTwoSum > playerOneSum &&
                    playerTwoSum > playerThreeSum &&
                    playerTwoSum > playerFourSum &&
                    playerTwoSum <= 21 || dealerSum > 21) {
                System.out.println(secondPlayer.getname() + " + wins!");
            } else if(playerThreeSum > dealerSum &&
                    playerThreeSum > playerOneSum &&
                    playerThreeSum > playerTwoSum &&
                    playerThreeSum > playerFourSum &&
                    playerThreeSum <= 21 || dealerSum > 21) {
                System.out.println(thirdPlayer.getname() + " wins!");
            } else if(playerFourSum > dealerSum &&
                    playerFourSum > playerOneSum &&
                    playerFourSum > playerTwoSum &&
                    playerFourSum > playerThreeSum &&
                    playerFourSum <= 21 || dealerSum > 21) {
                System.out.println(fourthPlayer.getname() + " wins!");
            } else {
                System.out.println("Dealer wins!");
            }
            this.toggle = true;
        }
}