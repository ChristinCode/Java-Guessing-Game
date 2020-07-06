package com.company;
import java.util.Scanner;
import java.util.Random;

public class GuessingGameApp {

    public static void main(String[] args) {
        /*int usersGuess = 0;  -is no longer needed in this method bc I only use this variable in the gameParameterWithLoop. Move variable to the gameParameterWithLoop*/
        int numberOfChances = 0;
        int numberForDice = getNumberFromDice();
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Please enter a number between 1-10:");
        gameParametersWithLoop(numberOfChances, numberForDice);
        System.out.println("Thanks for playing. See you next time!");
    }

    private static void gameParametersWithLoop(int numberOfChances, int numberForDice) {
        int usersGuess;
        while (numberOfChances < 3) {
            Scanner involvingUser = new Scanner(System.in);
            usersGuess = involvingUser.nextInt();
            if (usersGuess == numberForDice) {
                System.out.println("Congratulations! You have won!");
                break;
            } else if (userExitGame(usersGuess)) {
                System.out.println("Exit Game");
                break;
            } else if (usersGuess == 0) {
                numberOfChances--;
                System.out.println("Number was not between 1-10. Please enter a number between 1-10:");
            } else if (numberOfChances < 2) {
                System.out.println("You Lose! How about another chance:");
                if (usersGuess < numberForDice) {
                    System.out.println("Clue: Your guess was too low");
                }
                if (usersGuess > numberForDice) {
                    System.out.println("Clue: Your guess was too high");
                }
            } else {
                System.out.println("You Lose! The number was " + numberForDice + "!");
            }

            numberOfChances++;
        }
    }

    private static int getNumberFromDice() {
        Random dice = new Random();
        int numberForDice;
        numberForDice = 1 + dice.nextInt(10);
        return numberForDice;
    }

    private static boolean userExitGame(int usersGuess) {
        return usersGuess == -1;
    }

}
