import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class TestScoop {

  public static void main(String[] args) { // function main begins program execution

    // Fields
    // public ArrayList<IceCreamFlavor> flavors; >> Generates Error. Not sure how to incorporate
    // public ArrayList<MixInFlavor> mixins; >> Generates Error.
    // public ArrayList<Scoop> scoops; >> Generates Error.

    Scanner scanner = new Scanner(System.in);

    char choice = 'G';

    do {
      System.out.println("================");
      System.out.println("MICE Tester v0.1");
      System.out.println("================\n");
      System.out.printf("Enter a choice: \n"); // Promt user
      System.out.printf("1. (m)ixin\n");
      System.out.printf("2. (i)ce cream flavor\n");
      System.out.printf("3. (q)uit\n");
      System.out.printf("> ");
      choice = scanner.next().charAt(0); // Get char input
      // while( getchar() != '\n' ); VOID

      System.out.printf("\n");
      switch (choice) {
        case '1': // Dispaly: Dataset list
            System.out.printf("Option 1: Creating new MixIn Flavor!\n");
            System.out.printf("\n");
            break;
        case '2': // Display: Calcualted Averages
            System.out.printf("Option 2: Creating new Ice Cream Flavor!\n");
            System.out.printf("\n");
            break;
        case '3': // Gracefully terminate program
            System.out.printf("Good Bye!\n");
            System.out.printf("\n");
            break;
        default:
            System.out.printf("%s\n%s\n", "Invalid input!",
            "Please enter a number range (1 - 3).\n"); // Key selection is NOT an integer.
            break;
      } // end switch
      /* code */
    } while(choice != '3'); // end do..while

  } // edn main()

} // end TestScoop
