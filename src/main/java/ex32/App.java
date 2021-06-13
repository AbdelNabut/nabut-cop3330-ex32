/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Abdel Nabut
 */


package ex32;
import java.util.Locale;
import java.util.Scanner;

public class App 
{
    public static int getRandomNumber(int difficulty) {
        switch (difficulty) {
            case 1: return (int) (Math.random() * 10) + 1;
            case 2: return (int) (Math.random() * 100) + 1;
            case 3: return (int) (Math.random() * 1000) + 1;
        }
        return 0;
    }
    public static void main( String[] args )
    {
        int difficultyLevel = -1;
        int randomNumber;
        int userGuess = -1;
        int totalGuesses = 0;
        String userInput = "";
        String playAgain = "y";
        Scanner input = new Scanner(System.in);

        while(playAgain.equals("y")) {
            System.out.print("Enter the difficulty level (1, 2, or 3): ");
            while (difficultyLevel == -1) {
                userInput = input.next();
                if (InputValidator.isNumeric(userInput) && Integer.parseInt(userInput) >= 1 && Integer.parseInt(userInput) <= 3)
                    difficultyLevel = Integer.parseInt(userInput);
                else if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 3)
                    System.out.println("Please input a difficulty between 1 and 3.");
                else
                    System.out.println(userInput + " is not a number. Please try again.");
                System.out.println(difficultyLevel);
            }
            randomNumber = getRandomNumber(difficultyLevel);
            System.out.print("I have my number, whats your guess? ");
            while (Integer.parseInt(userInput) != randomNumber) {
                userInput = input.next();
                totalGuesses++;
                if (!InputValidator.isNumeric(userInput))
                    System.out.println(userInput + " is not a number. Please try again.");
                else if (Integer.parseInt(userInput) > randomNumber)
                    System.out.println("Too high! Guess again!");
                else if (Integer.parseInt(userInput) < randomNumber)
                    System.out.println("Too low! Guess again!");
                else
                    System.out.println("You got it in " + totalGuesses + " guesses!");
            }
            System.out.println("Do you wish to play again (Y/N)?");
            playAgain = input.next().toLowerCase(Locale.ROOT);
        }

    }
}
