package com.github.zipcodewilmington.casino.games;

import java.util.Random;
import java.util.Scanner;

public class SlotsGame {
   public static final int balance = 100;
   public static  void main (String[] args) {
       int bet = 100;
       int remainingBalance = balance;
       int slot1;
       int slot2;
       int slot3;

       Random generator = new Random();
       System.out.println("Starting Balance = ");
       Scanner scanner = new Scanner(System.in);
       bet = scanner.nextInt();
   }

   public void run() {
       new SlotsGame();
   }
}
