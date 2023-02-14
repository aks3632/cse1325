import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {
  // Fields - Declated outside methods!
  private ArrayList<Product> products = new ArrayList<>();
  private ArrayList<Product> shoppingCart = new ArrayList<>();


  public void DisplayItems() {
  }


  public int Menu() { // Function Method | Removed static from header

    products.add(new Taxfree("Milk", 2.85));        products.add(new Taxfree("Bread", 1.99));
    products.add(new Taxfree("Cheese", .85));       products.add(new Taxfree("Eggs", 6.95));
    products.add(new Taxed("IceCream", 4.95));      products.add(new Taxed("Poptarts", 3.49));
    products.add(new Taxed("Oreos", 5.99));
    /* OR
    ArrayList<Product> products = new ArrayList<>(
        Arrays.asList(new Product(Milk, 2.85), new Product(Bread, 1.99),   new Product(cheese, .85),
                      new Product(Eggs, 6.95), new Product(Ice Cream, 4.95),  Product(Poptarts, 3.49)));
    */

    // System.out.println(products.get(0)); OR System.out.println(products.get(0).toString());

    Taxed.setTaxRate(0.0825);

    // Stystem.out.println(products.price());


    int input = 0;

    System.out.println("====================");
    System.out.println("Welcome to the Store");
    System.out.println("=====================\n");
    System.out.printf("Enter a choice: \n"); // Promt user
    System.out.println("1. "  + products.get(0).toString());  // (M)ilk
    System.out.println("2. "  + products.get(1).toString());  // (B)read
    System.out.println("3. "  + products.get(2).toString());  // (C)heese
    System.out.println("4. "  + products.get(3).toString());  // (E)ggs
    System.out.println("5. "  + products.get(4).toString());  // (I)ce Cream
    System.out.println("6. "  + products.get(5).toString());  // (P)optarts
    System.out.println("7. "  + products.get(6).toString());  // (O)reos
    System.out.println("8. (q)uit?\n");
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
      if (input <0 || input > 8)
      {
        throw new IllegalArgumentException("\nInvalid menu choice. Good bye!");
        // System.out.println("\n Invalid menu choice please try again");
      } // end if
      return input;

    } while (input < 0 || input > 8);
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
              System.out.println("Option 1: Milk ($2.85)" + products.get(0).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 2: // Display: 2nd choice
              System.out.printf("Option 2: Bread ($1.99)\n" + products.get(1).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 3: // Display: 2nd choice
              System.out.printf("Option 3: Cheese ($.85)\n" + products.get(2).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 4: // Display: 2nd choice
              System.out.printf("Option 3: Eggs ($6.95)\n" + products.get(3).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 5: // Display: 2nd choice
              System.out.printf("Option 3: Ice Cream ($4.95)\n" + products.get(4).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 6: // Display: 2nd choice
              System.out.printf("Option 3: Poptarts ($3.49)\n" + products.get(5).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 7: // Display: 2nd choice
              System.out.printf("Option 3: Oreos ($5.99)\n" + products.get(6).toString());
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              break;

          case 8: // Gracefully terminate program
              System.out.printf("Good Bye!\n");
              System.out.printf("\n");
              System.exit(-1);
              break;

          default:
              System.out.printf("%s\n%s\n", "Invalid input!",
              "Please enter a number range (1 - 8).\n"); // Key selection is NOT an integer.
              break;
        } // end switch
        /* code */
      } while((choice != 8)); // end do..while |  || (choice != '4')

  } // end start()


  public static void main(String[] args) { // Function main() begins program execution

    Store store = new Store();
    store.start();

  } // end function main()
} // end class
