import java.util.Scanner;
import java.util.Random;
public class SlotMachine {
    public static void main(String[] args) {
        // Welcome & Symbols
        System.out.println("***********************");
        System.out.println("Welcome to Java Slots");
        System.out.println("Symbols: 🐱🐭🐻🐒🐧");
        System.out.println("***********************");
        // Declare variables
        String[] row;
        int balance = 100;
        int bet;
        String playAgain;
        int payout = 0;

        // Create Method for spinning
        Scanner scanner = new Scanner(System.in);

        while (balance > 0) {
            System.out.println("Current balance: " + balance);
            System.out.print("Place your bet: ");
            bet = scanner.nextInt();
            if (bet <= 0 || bet > balance) {
                System.out.println("Invalid bet");
                continue;
            } else {
                balance -= bet;
            }
            System.out.println("Spinning......");
            System.out.println("********************");
            // Create Method for printing
            row = spinRow();
            printRow(row);
            System.out.println("********************");
            // Judge
            payout = getPayout(row, bet);
            if (payout > 0) {
                balance += payout;
            } else {
                System.out.println("Thanks for playing!");
            }
            System.out.print("Do you want to play again: ");
            playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("y")){
                break;
            }
            // playAgain?
        }
        scanner.close();
    }

    static String[] spinRow() {
        String[] Symbols = {"🐱", "🐭", "🐻", "🐒", "🐧"};
        String[] row = new String[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            row[i] = Symbols[random.nextInt(Symbols.length)];

        }
        return row;
    }

    static void printRow(String[] row) {
        System.out.println(" " + String.join(" | ", row));
    }

    static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🐱" -> bet * 3;
                case "🐭" -> bet * 4;
                case "🐻" -> bet * 5;
                case "🐒" -> bet * 10;
                case "🐧" -> bet * 20;
                default -> 0;
            };
        } else if (row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🐱" -> bet * 2;
                case "🐭" -> bet * 3;
                case "🐻" -> bet * 4;
                case "🐒" -> bet * 5;
                case "🐧" -> bet * 6;
                default -> 0;
            };
        } else if (row[1].equals(row[2])) {
            return switch (row[1]) {
                case "🐱" -> bet * 2;
                case "🐭" -> bet * 3;
                case "🐻" -> bet * 4;
                case "🐒" -> bet * 5;
                case "🐧" -> bet * 6;
                default -> 0;
            };
        }
       return 0;
    }
}