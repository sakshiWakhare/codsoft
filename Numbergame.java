// package numbergame;

import java.util.Scanner;
import java.util.Random;

public class Numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int ATTEMPTS_LIMIT = 5;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Round! Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ".");

            while (!guessedCorrectly && attempts < ATTEMPTS_LIMIT) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            totalAttempts += attempts;

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playChoice = scanner.next();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);

        scanner.close();
    }
}
