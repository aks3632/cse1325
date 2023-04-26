
import java.util.ArrayList;

public class Question {

  // Constructor | has NO return value
  public Question(String question, ArrayList<String> answers, int rightAnswer) {
    this.question = question;
    /* answers = new ArrayList<>();
    | Size can change dynamically!
    |& must be initialized using new*/
    this.answers = new ArrayList<>(); // this.answers = answers;
    this.rightAnswer = rightAnswer;
    this.questionNumber = nextQuestionNumber++;

    /*
    // Data validation | Notice: Bypass rule of NO return value
    if((rightAnswer <= 0) || (rightAnswer > questionNumber)) {
      throw new illeagaArgumentException("%s\n %s\n %s\n","Invalid tally of answers."
                                        , "Can't exceed correct answers"
                                        , "than there are original Questions.");

    } // end if
    */

  } // end Question Constructor

  public boolean checkAnswer(int answer) {
    return true; // Test pt ***
  }

  @Override
  public String toString() {
    return " "; // + question + answers + rightAnswer?
  }


  // Fields | 5 private fields
  private static int nextQuestionNumber = 1;  // Static field
  private int questionNumber;   // Final field

  private String question;
  private ArrayList<String> answers; // OR String[] answers;
  private int rightAnswer;


}
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
import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Quizzer {

  public static void main(String[] args) { // Function main() begins program execution

    /*
    try {
      println("This is a test");
      // should instance

    } catch(Exception e) {
      System.err.println(e.getMessage());
      System.exit(-1);
      // ,"Copy (catch) the exception object into e"
      // ,"Print exception message"
      // ,"Exit and send -1 result to the OS");
    } // end try-catch
    */
  }
} // end main()
