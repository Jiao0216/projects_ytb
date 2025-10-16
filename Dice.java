import java.util.Scanner;
import java.util.Random;
public class Dice {
    public static void main(String[] args) {
        //Declare variables
       int numOfDice;
       int total=0;
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();

        System.out.print("Enter the number of dice: ");
        numOfDice = scanner.nextInt();

        //check if the numOfDice >0
        if(numOfDice>0){
            for(int i = 0; i < numOfDice; i++){
                int roll;
                roll = random.nextInt(1,7);
                System.out.println("Your rolling number is: " +roll);
                display(roll);
                total+=roll;
            }
            System.out.println("Your total is "+total);
        }else{
            System.out.println("Invalid number");
        }
        //for loop to get random dice numbers
        //get the total of numers
        //ASCII
    }
    static void display(int roll){
        String Dice1 = """
                -------
               |       |
               |   ●   |
               |       |
                -------
                """;
        String Dice2 = """
                -------
               |  ●    |
               |       |
               |     ● |
                -------
                """;
        String Dice3 = """
                -------
               | ●     |
               |   ●   |
               |     ● |
                -------
                """;
        String Dice4 = """
                -------
               | ●   ● |
               |       |
               | ●   ● |
                -------
                """;
        String Dice5 = """
                -------
               | ●   ● |
               |   ●   |
               | ●   ● |
                -------
                """;
        String Dice6 = """
                -------
               | ●   ● |
               | ●   ● |
               | ●   ● |
                ------- 
                """;
        switch(roll){
            case 1 -> System.out.println(Dice1);
            case 2 -> System.out.println(Dice2);
            case 3 -> System.out.println(Dice3);
            case 4 -> System.out.println(Dice4);
            case 5 -> System.out.println(Dice5);
            case 6 -> System.out.println(Dice6);
            default -> System.out.println("Invalid number");
        }

    }
}
