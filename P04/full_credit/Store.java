import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {
  // Fields - Declated outside methods!
  private ArrayList<Product> products = new ArrayList<>();
  private ArrayList<Product> shoppingCart = new ArrayList<>();

  /*
  ArrayList<Product> products = new ArrayList<>(
      Arrays.asList(new Product(Milk, 2.85), new Product(Bread, 1.99),   new Product(cheese, .85),
                    new Product(Eggs, 6.95), new Product(Ice Cream, 4.95),  Product(Poptarts, 3.49)));
  */

  public void DisplayItems() {
    products.add(new Taxfree("Milk", 2.85));        products.add(new Taxfree("Bread", 1.99));
    products.add(new Taxfree("Cheese", .85));       products.add(new Taxfree("Eggs", 6.95));
    products.add(new Taxed("IceCream", 4.95));      products.add(new Taxed("Poptarts", 3.49));
    products.add(new Taxed("Oreos", 5.99));
  }


  public static int Menu() { // Function Method
    int input = 0;

    System.out.println("====================");
    System.out.println("Welcome to the Store");
    System.out.println("=====================\n");
    System.out.printf("Enter a choice: \n"); // Promt user
    System.out.printf("1. (M)ilk\n");
    System.out.printf("2. (B)read\n");
    System.out.printf("3. (C)chees\n");
    System.out.printf("4. (q)uit?\n");
    System.out.printf("> Chose a number: ");
    Scanner number = new Scanner(System.in);

    do {

      try
      {
        input = Integer.parseInt(number.nextLine()); // num.nextInt();
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(-1);
      } // end try...catch
      if (input <0 || input > 4)
      {
        throw new IllegalArgumentException("\nInvalid menu choice. Good bye!");
        // System.out.println("\n Invalid menu choice please try again");
      } // end if
      return input;

    } while (input < 0 || input > 4);
  } // end menu


  public void start() {
      // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
      // can now access non-static fields

      char choice = (char)Menu(); // Obtains function Menu

      do {
        Scanner scanner = new Scanner(System.in);
        choice = (char)Menu();  // Get char input | ERROR prone: choice = scanner.next().charAt(0);
        // VOID | C++ while( getchar() != '\n' );

        System.out.printf("\n");
        switch (choice) {
          case 1: // Dispaly: Dataset list
              System.out.printf("Option 1: Milk ($2.85)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 2: // Display: 2nd choice
              System.out.printf("Option 2: Bread ($1.99)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 3: // Display: 2nd choice
              System.out.printf("Option 3: Cheese ($.85)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 4: // Gracefully terminate program
              System.out.printf("Good Bye!\n");
              System.out.printf("\n");
              System.exit(-1);
              break;

          default:
              System.out.printf("%s\n%s\n", "Invalid input!",
              "Please enter a number range (1 - 4).\n"); // Key selection is NOT an integer.
              break;
        } // end switch
        /* code */
      } while((choice != 4)); // end do..while |  || (choice != '4')

  } // end start()


  public static void main(String[] args) { // Function main() begins program execution

    Store store = new Store();
    store.start();

  } // end function main()
} // end class
