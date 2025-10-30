import java.util.ArrayList;
import java.util.Scanner;
public class HANGMAN {
    public static void main(String[] args) {
        String word = "pizza";

        Scanner scanner = new Scanner(System.in);
        int wrongGuesses = 0;
        ArrayList<Character> wordState = new ArrayList<Character>();


            for (int i = 0; i < word.length(); i++) {
                wordState.add('_');
            }
            System.out.println("Welcome to Hangman!\n");

        while (wrongGuesses < 6) {
            System.out.println(GameArt(wrongGuesses));
            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }

            System.out.println();
            System.out.print("Guess the word: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!\n");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }

                }
                if (!wordState.contains('_')){
                    System.out.println(GameArt(wrongGuesses));
                    System.out.println("You Win!");
                    System.out.println("The word was: "+ word);
                    break;
                }
        }
            else{
                    wrongGuesses++;
                    System.out.println("Wrong Guess!");
                    GameArt(wrongGuesses);

                }
            }
           if(wrongGuesses >= 6){
               System.out.println(GameArt(wrongGuesses));
               System.out.println("Game Over!");
               System.out.println("The word was " + word);
           }
        }

        public static String GameArt ( int wrongGuesses){
            return switch (wrongGuesses) {
                case 0 -> """
                        
                        
                        
                        """;
                case 1 -> """
                         o
                        
                        
                        """;
                case 2 -> """
                         o
                         |
                        
                        """;

                case 3 -> """
                         o
                        /|
                        
                        """;
                case 4 -> """
                         o
                        /|\\
                        
                        """;
                case 5 -> """
                         o
                        /|\\
                        |              
                        """;
                case 6 -> """
                         o
                        /|\\
                        | |
                        """;
                default -> "";
            };

        }


    }
