import java.util.Scanner;
import java.util.Random;
public class Rps_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Declare variables
        String[] game = {"rock","paper","scissors"};
        String playAgain = "yes";
        String move;
        String computerMove;
        // User play
        do{
        System.out.print("Enter your move: ");
        move = scanner.nextLine().toLowerCase();
        if(!move.equals("rock") && !move.equals("scissors") && !move.equals("paper")) {
            System.out.println("Invalid move");
        }else{
            computerMove = game[random.nextInt(3)];
            System.out.println("Computer: " + computerMove);
            //Judge
            if(move.equals(computerMove)){
                System.out.println("It is tie!");
            }else if(move.equals("rock") && computerMove.equals("scissors") || move.equals("paper") && computerMove.equals("rock") || move.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("You win!");
            }else{
                System.out.println("You lose!");
            }

        }
        System.out.print("Play again?(yes/no): ");
        playAgain = scanner.nextLine().toLowerCase();

        }while(playAgain.equals("yes"));
        System.out.println("Thanks for playing!");


        scanner.close();
            }
        }
        // play_again
