import java.util.Scanner;
public class Quiz {
    public static void main(String[] args) {
        // quiz game

        // Question Array[]
        String[] questions = {"1. What is the brain of a computer?",
                "2. Who is the Father of a computer?",
                "3. What id the main function of a router? ",
                "4. What was the first programming language? "
        };
        // Options Array[][]
        String[][] options = {{"1. CPU","2. GPU", "3. Hard Drive", "4. Ram"},
                {"1. Steve Jobs", "2. Bill Gates", "3. Alan Turing", "4. Charles Babbage"},
                {"1. Storing files ", "2. Encrypting data ", "3. Directing internet traffic ","4. Managing passwords"},
                {"1. Java ", "2. Python ", "3. C ","4. Fortran "}
        };
        // Declare variables
        int[] answers = {1,4,3,4};
        int guess;
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        //Welcome message
        System.out.println("Welcome to the Quiz");
        //Questions loop
        for(int i= 0; i< questions.length;i++){
            System.out.println(questions[i]);
            for (String option: options[i]){
                System.out.println(option);
            }
            System.out.print("Enter your answer: ");
            guess = scanner.nextInt();
            if(guess ==  answers[i]){
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("Incorrect!");
            }

        }
        System.out.println("Your score is: " + score + " out of " + questions.length);
        scanner.close();
    }


    //Check your answer
    // Display final score


}




