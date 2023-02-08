import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Quizzer {

  public static void main(String[] args) { // Function main() begins program execution

    Quiz quiz = new Quiz();

    quiz.takeQuiz();
    System.out.println(quiz.takeQuiz());

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
