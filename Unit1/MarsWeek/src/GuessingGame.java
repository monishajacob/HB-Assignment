import java.util.InputMismatchException;
import java.util.Scanner;
public class GuessingGame {

    public GuessingGame() {
        int attempt = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome, what's your name?");
        String name = scan.nextLine();

        System.out.println(name + ", I'm thinking of a num between 1 and 100.");
        System.out.println("Try to guess my num.");
        System.out.println("Your attempt on guessing? ");
        
        int num = (int) (Math.random()*101);

        

        while (true) {

            int guess;
            try {
                guess = scan.nextInt();
            } catch (InputMismatchException e) {
                String invalid = scan.next(); 
                System.out.println("Invalid integer, try again");
                continue;
            } 

            if (guess < 1 || guess > 100) {
                System.out.println(guess + " Out of range, try again");
                continue;
            }

            attempt++;
            if (guess < num) {
               System.out.println("Your guess is too low, try again. ");
            } else if (guess > num) {
               System.out.println("Your guess is too high, try again. ");
            } else {
               System.out.println("Bravo " + name);
               System.out.println("You found my num in " + attempt + " attempt!");
               break;
            }
         
         }


    }
   
}
