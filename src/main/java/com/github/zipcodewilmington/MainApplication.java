package com.github.zipcodewilmington;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a game");
        System.out.println("[1 = Poker] [2 = Roulette] [3 = Blackjack] [4 = War] " +
                "[5 = Slots] [6 = GoFish] [7 = CardMemory] [8 = RPSLS]");

        int userInput = scanner.nextInt();

        switch(userInput){
            case 1:
                System.out.println("You chose Poker");
                break;
            case 2:
                System.out.println("You chose Roulette");
                break;
            case 3:
                System.out.println("You chose Blackjack");
                break;
            case 4:
                System.out.println("You chose War");
                break;
            case 5:
                System.out.println("You chose Slots");
                break;
            case 6:
                System.out.println("You chose GoFish");
                break;
            case 7:
                System.out.println("You chose CardMemory");
                break;
            case 8:
                System.out.println("You chose RPSLS");
                break;
            default:
                System.out.println("Please Select a game");
                break;
        };
        new Casino().run();
    }
}
