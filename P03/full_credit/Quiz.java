import java.util.ArrayList;
import java.util.Scanner;

 public class Quiz {

   // Constructor invoked by e.g.?
   public Quiz() {

     // Composition: The Question is contained entirely within the Quiz
     for(int i=0; i< questions.size(); ++i) {
     } // end for

     loadQuiz(); // Invoked per instructions

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

     Scanner scanner = new Scanner(System.in);  // Syntax for Input
     String guess = scanner.nextLine();       // Random guess from USER
     String password = "Austin";  // Correct hidden answer

     System.out.print(Texas); // Prompt user
     // q[0] = new Question (Texas, ArrayList.toString(guess), password);

   } // end loadQuiz

   // Fields
   private ArrayList<Question> questions; // OR Question[] questions;

 } // end class Quiz
