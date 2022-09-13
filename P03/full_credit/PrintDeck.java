import java.lang.Enum;
import java.util.Scanner;
import java.util.Date;
import java.util.Random;

public class PrintDeck { // Ref to code_from_slide Foder-03-date3
  public static void main(String[] args) { // function main begins program execution

    Date d = new Date(22,9,13);
    long t = d.getTime(); // t - time varialbe - NULL OR ADDRESS

    int a = Rank.min; // Range
    int b = Rank.max;
    int index = 0;

    //for (int i = 0; i < 9; i++) { // Ten rand numbers generate
      index = ((int) Math.random()) % (b-a) + a;

    Rank r = new Rank(index);

    Card c1 = new Card(r, Suit.values()[index]);
    System.out.println(c1.toString());

  } // end main()
}
