package com.github.zipcodewilmington;

public class Cards {
    private Suits suits;
    private int number;


    public Cards(Suits suits, int number) {
        this.suits = suits;
        if(number >= 1 && number <= 13) {
            this.number = number;
        } else {
            System.err.println(number + " is not a valid Card");
            System.exit(1);
        }
    }
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        String numberStr = "Error";
        switch(this.number) {
            case 2:
                numberStr = "Two";
                break;
            case 3:
                numberStr = "Three";
                break;
            case 4:
                numberStr = "Four";
                break;
            case 5:
                numberStr = "Five";
                break;
            case 6:
                numberStr = "Six";
                break;
            case 7:
                numberStr = "Seven";
                break;
            case 8:
                numberStr = "Eight";
                break;
            case 9:
                numberStr = "Nine";
                break;
            case 10:
                numberStr = "Ten";
                break;
            case 11:
                numberStr = "Jack";
                break;
            case 12:
                numberStr = "Queen";
                break;
            case 13:
                numberStr = "King";
                break;
            case 1:
                numberStr = "Ace";
                break;
        }
        return numberStr + " of " + suits.toString();
    }
}