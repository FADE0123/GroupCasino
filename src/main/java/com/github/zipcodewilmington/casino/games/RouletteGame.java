package com.github.zipcodewilmington.casino.games;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;
public class RouletteGame implements GameInterface {

        Scanner keyboard = new Scanner(System.in);

        int total = 10;
        int amount;
        int choice, win = 0, lose = 0, spin = 0;
        int number;
        int rouletteNum;
        int result;
        char response;
        int resultArr[] = new int[37];

    public RouletteGame() {
        run();
    }
    @Override
    public void add(PlayerInterface player) {
    }
    @Override
    public void run() {
                System.out.println("Enter bet amount: ");
                amount = keyboard.nextInt();
                System.out.println("0 - Even\n1 - Odd\n2 - Number\n");
                choice = -1;
                while (choice < 0 || choice > 2) {
                    System.out.println("Place your bet on: ");
                    choice = keyboard.nextInt();
                }
                number = 0;
                if (choice == 2) {
                    while (number < 1 || number > 36) {
                        System.out.println("Place your bet on number(1-36): ");
                        number = keyboard.nextInt();
                    }
                }
                int generator = RandomNumberGenerator.randomizedNumber((36) + 1);
                rouletteNum = generator;
                spin++;
                System.out.println("Roulette number: " + rouletteNum);

                if (choice == 2) {
                    if (rouletteNum == number)
                        result = 35;
                    else
                        result = 0;
                } else {
                    if (rouletteNum == 0 || rouletteNum % 2 != choice)
                        result = 0;
                    else
                        result = 1;
                }
                if (result > 0) {
                    System.out.println("Congratulations! You win!");
                    System.out.printf("You have won  \n", result * amount);
                    System.out.printf("Here's your money back:  \n", (result + 1) * amount);
                    total = (result + 1) * amount + total;
                    win++;
                    resultArr[rouletteNum]++;
                } else {
                    System.out.println("You lose. Better luck next time!");
                    System.out.printf("You have lost  \n", (result + 1) * amount);
                    total = total - (result + 1) * (amount);
                    lose++;
                    resultArr[rouletteNum]++;
//                    if (total <= 0) {
//                        break;
//                    }
                }
                for (int totals = 1; totals < 36; totals++) {
                    if (resultArr[totals] > 0) {
                        System.out.println("The Number " + totals + " won " + resultArr[totals] + " times.");
                    }
                }
                System.out.println("You have " + total + " remaining.");
                System.out.println("You have won " + win + " games.");
                System.out.println("you have lost " + lose + " games.");
                System.out.println("The wheel has been spun " + spin + " times.");
        System.out.println("\n");
        Casino casino = new Casino();
        casino.run();
        }




    @Override
    public void remove(PlayerInterface player) {

    }
}


