import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {

  public void start() {
      // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
      // can now access non-static fields
      Scanner scanner = new Scanner(System.in);

      char choice = 'G';

      do {
        System.out.println("====================");
        System.out.println("Welcome to the Store");
        System.out.println("=====================\n");
        System.out.printf("Enter a choice: \n"); // Promt user
        System.out.printf("1. (M)ilk\n");
        System.out.printf("2. (B)read\n");
        System.out.printf("3. (C)chees\n");
        System.out.printf("4. (q)uit?\n");
        System.out.printf("> ");
        choice = scanner.next().charAt(0); // Get char input
        // while( getchar() != '\n' ); VOID

        System.out.printf("\n");
        switch (choice) {
          case '1': // Dispaly: Dataset list
              System.out.printf("Option 1: Milk ($2.85)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case '2': // Display: 2nd choice
              System.out.printf("Option 2: Bread ($1.99)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case '3': // Display: 2nd choice
              System.out.printf("Option 3: Cheese ($.85)\n");
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case '4': // Gracefully terminate program
              System.out.printf("Good Bye!\n");
              System.out.printf("\n");
              break;

          default:
              System.out.printf("%s\n%s\n", "Invalid input!",
              "Please enter a number range (1 - 4).\n"); // Key selection is NOT an integer.
              break;
        } // end switch
        /* code */
      } while(choice != '4'); // end do..while

  } // end start()

  public static void main(String[] args) {

    Store store = new Store();
    store.start();


    /*
    ArrayList<Product> product = new ArrayList<>(
        Arrays.asList(new Product(Milk, 2.85), new Product(Bread, 1.99),   new Product(cheese, .85),
                      new Product(Eggs, 6.95), new Product(Ice Cream, 4.95),  Product(Poptarts, 3.49)));
    */

    /* or
    ArrayList<Product> product = new ArrayList<>();
    product.add(new Product(Milk, 2.85));   product.add(new Product(Bread, 1.99));
    product.add(new Product(cheese, .85));     product.add(new Product(Eggs, 6.95));
    product.add(new Product(Ice Cream, 4.95));     product.add(new Product(Poptarts, 3.49));
    */

    // Fields
    // private ArrayList<Product> product = new ArrayList<>();
    // private ArrayList<Product> shoppingCart = new ArrayList<>();
  } // end function main()
} // end class
