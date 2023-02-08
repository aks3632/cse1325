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
      throw new IllegalArgumentException("Invalid tally of answers."
          + "Can't exceed correct answers"
          + "than there are original Questions.");
    } // end if
    */

  } // end Question Constructor

  public boolean checkAnswer(int answer) {
    return true; // Test pt ***
  }

  @Override
  public String toString() {
    return " " + question; // + question + answers + rightAnswer?
  }

  // Fields | 5 private fields
  private static int nextQuestionNumber = 1;  // Static field
  private int questionNumber;   // Final field

  private String question;
  private ArrayList<String> answers; // OR String[] answers;
  private int rightAnswer;
}
