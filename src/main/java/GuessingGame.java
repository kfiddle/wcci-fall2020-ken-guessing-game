import java.util.Scanner;

public class GuessingGame {
    int numberToBeGuessed = (int) (Math.random() * 99 + 1);
    int guess;
    int tries;


    public int temperature() {
        return Math.abs(guess - numberToBeGuessed);
    }


    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 0 and 100. How many guesses will you need to get it?");
        game.tries = input.nextInt();
        System.out.println("And now for a first guess...?");
        game.guess = input.nextInt();

        while (true) {
            int temp1 = game.temperature();
            if (game.temperature() == 0) {
                System.out.println("Well done! You're evidently not a loser.");
                System.exit(0);

            } else {
                System.out.println("Let's have another guess...?");
                game.guess = input.nextInt();
                if (game.tries == 0){
                    break;
                }

                if (temp1 > game.temperature()) {
                    System.out.println("Warmer...");
                    game.tries--;

                } else {
                   System.out.println("Getting colder...");
                   game.tries--;
                }
            }
        }

        System.out.println("Sorry. you just couldn't get to " + game.numberToBeGuessed + " in time.");
    }
}
