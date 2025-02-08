
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/* This task is about to develop a number game in which the program itself generate a random number from 1 to 100 store in itself and also provide user a prompt 
to write to think about number and write it and check the numbers from user and program itself  */

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            int random_number = ThreadLocalRandom.current().nextInt(1, 101);
            int limit = 3;
            int currentAttempt = 1;
            int score = 0;
            while (currentAttempt <= limit) {
                System.out.print("Guess Your Number: ");
                int userGuess = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline character
                
                if (userGuess == random_number) {
                    System.out.println("Right! You Won");
                    score = limit - currentAttempt + 1;
                    break;
                } else if (userGuess > random_number) {
                    System.out.println("It's higher! Try again");
                } else {
                    System.out.println("It's lower! Try again");
                }
                currentAttempt++;
            }
            System.out.println("Your attempt is finished");
            System.out.println("The correct number was " + random_number);
            System.out.println("Your Score is: " + score);

            // Ask to play again
            System.out.print("Do you want to play again? If yes, write y: ");
            String answer = sc.nextLine();  // Correctly read the play-again input
            if (answer.equalsIgnoreCase("Y")) {
                playAgain = true;
            } else {
                playAgain = false;
                System.out.println("Thanks for playing! Hope you enjoyed.");
            }
        }
        sc.close();
    }
}
