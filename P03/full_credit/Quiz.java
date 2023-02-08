import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

 public class Quiz {

   // Constructor invoked by e.g.?
   public Quiz() {
     loadQuiz();
   } // end Quiz Constructor

   // Methods
   public double takeQuiz() {

     //String s = "q[0].toString()";
     //System.out.print(s.trim());

     return 100; // Test pt
   } // end takeQuiz

   private void loadQuiz() {

     Question[] q = new Question[2]; // instance Question

     /* Question 1 */
     String Texas = """
     1. The capital of Texas is
     1) Dallas
     2) Houston
     3) Austin
     4) Arlington \n""";

     ArrayList<String> guess = new ArrayList<>();

     System.out.print(Texas); // Prompt user
     Scanner scanner = new Scanner(System.in);  // Syntax for Input
     guess.add(scanner.nextLine());       // Random guess from USER
     String password = "Austin";  // Correct hidden answer
     System.out.println(password.equals(guess)); // Compares value of 2 Strings

     int res;
     // Performing ternary operation
     res = (password.equals(guess)) ? (1) : (0);
     q[0] = new Question (Texas, guess, res);

     // Question 2
     String Addition = """
     1. What is 1 + 1?
     1) 2
     2) 14
     3) -42
     4) 0 \n""";

     System.out.print(Addition); // Prompt user
     guess.add(scanner.nextLine());       // Random guess from USER
     password = "2";  // Correct hidden answer
     System.out.println(password.equals(guess)); // Compares value of 2 Strings

     // Performing ternary operation
     res = (password.equals(guess)) ? (1) : (0);
     q[1] = new Question (Addition, guess, res);

   } // end loadQuiz

   // Fields
   private ArrayList<Question> questions; // OR Question[] questions;
 } // end class Quiz
