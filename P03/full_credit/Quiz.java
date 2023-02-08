import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

 public class Quiz {

   // Constructor invoked by e.g.?
   public Quiz() {

     /*
     // Composition: The Question is contained entirely within the Quiz
     for(int i=0; i< questions.size(); ++i) {
       // questions.add(new loadQuiz()); // Invoked per instructions
     } // end for
     */

   } // end Quiz Constructor

   // Methods
   public double takeQuiz() {

     return 0; // Test pt
   } // end takeQuiz

   private void loadQuiz() {

     Question[] q = new Question[1]; // instance Question

     String Texas = """
     1. The capital of Texas is
     1) Dallas
     2) Houston
     3) Austin
     4) Arlington """;

     ArrayList<String> guess = new ArrayList<>();

     Scanner scanner = new Scanner(System.in);  // Syntax for Input
     guess.add(scanner.nextLine());       // Random guess from USER
     String password = "Austin";  // Correct hidden answer
     System.out.println(password.equals(guess)); // Compares value of 2 Strings

     int res;
     // Performing ternary operation
     res = (password.equals(guess)) ? (1) : (0);

     System.out.print(Texas); // Prompt user
     q[0] = new Question (Texas, guess, res);

   } // end loadQuiz

   // Fields
   private ArrayList<Question> questions; // OR Question[] questions;

 } // end class Quiz
