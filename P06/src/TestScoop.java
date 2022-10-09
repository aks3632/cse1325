import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;


public class TestScoop {


  private ArrayList<MixInFlavor> mixins = new ArrayList<>();
  private ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
  private ArrayList<Scoop> scoops = new ArrayList<>();

  /* Professor Rice's code */
  private Console console = System.console();

  private void addMixInFlavor() {
      mixins.add(new MixInFlavor(
          console.readLine("Name? "),
          console.readLine("Description? "),
          Integer.parseInt(console.readLine("Price? ")),
          Integer.parseInt(console.readLine("Cost? "))
      ));
  }

  private void addIceCreamFlavor() {
      flavors.add(new IceCreamFlavor(
          console.readLine("Name? "),
          console.readLine("Description? "),
          Integer.parseInt(console.readLine("Price? ")),
          Integer.parseInt(console.readLine("Cost? "))
      ));
  }
  /* ^^Professor Rice's code */

  public void start() {
      // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
      // can now access non-static fields
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
              addMixInFlavor(); /* << Professor Rice's code */
              break;
          case '2': // Display: Calcualted Averages
              System.out.printf("Option 2: Creating new Ice Cream Flavor!\n");
              System.out.printf("\n");
              addIceCreamFlavor(); /* << Professor Rice's code */
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

  } // end start()

  // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
  public static void main(String[] args) { // function main begins program execution
    TestScoop testscoop = new TestScoop();
    testscoop.start();
  } // end main()

} // end TestScoop
