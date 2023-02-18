import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Store {
  // Fields - Declerated outside methods!
  private ArrayList<Product> products = new ArrayList<>();
  private ArrayList<Product> shoppingCart = new ArrayList<>();

  public int Menu() { // Function Method | Removed static from header

    products.add(new Taxfree("Milk", 2.85));        products.add(new Taxfree("Bread", 1.99));
    products.add(new Taxfree("Cheese", .85));       products.add(new Taxfree("Eggs", 6.95));
    products.add(new Taxed("IceCream", 4.95));      products.add(new Taxed("Poptarts", 3.49));
    products.add(new Taxed("Oreos", 5.99));
    /* OR
    ArrayList<Product> products = new ArrayList<>(
        Arrays.asList(new Product(Milk, 2.85), new Product(Bread, 1.99),   new Product(cheese, .85),
                      new Product(Eggs, 6.95), new Product(Ice Cream, 4.95),  Product(Poptarts, 3.49))); */

    /* Remember, static methods can be called
     from the class without an object, for example, */
    Taxed.setTaxRate(0.0825);

    /* Option 1 */
    // Taxfree tfree = new Taxfree("Milk", 2.85);
    // tfree.price();

    /* **************** Display Menu of Predefined Taxable & Tax-free Items **************** */
    int input = 0;

    System.out.println("====================");
    System.out.println("Welcome to the Store");
    System.out.println("=====================\n");

    try {
      // System.out.printf("Enter a choice: \n"); // Promt user
      /* Option 2 | For each loop */
      int i = 0; // index count for items
      for(Product txCode : products) { // HINT: derived via ArrayList | Creates Menu List
        System.out.print(i + ") " + products.get(i).toString().strip().trim());
        System.out.println(""+ "    " + "\t\t\t\t" + String.format("$   %.2f", txCode.price()));
        // System.out.println("" + "\t" + txCode.price());
        i++;
        if(i > 6) { // Menu list displayed restricts to 7 items ONLY
          break;
        } // end if
      } // end for each loop
      /* Substituted above | System.out.println(products.get(0)); OR System.out.println(products.get(0).toString());
      System.out.println("0. " + products.get(0).toString());  // (M)ilk || tfree.price()   System.out.println("1. " + products.get(1).toString());  // (B)read
      System.out.println("2. " + products.get(2).toString());  // (C)heese                  System.out.println("3. " + products.get(3).toString());  // (E)ggs
      System.out.println("4. " + products.get(4).toString());  // (I)ce Cream               System.out.println("5. " + products.get(5).toString());  // (P)optarts
      System.out.println("6. " + products.get(6).toString());  // (O)reos */
    } catch (RuntimeException e) {
      System.err.println("Ending progarm: " + e.getMessage());
      System.exit(-1);
    } // end try..catch

    System.out.println("7) (q)uit?\n"); // end Menu List
    System.out.println("\nCurrent Order"); // 2nd Porcess begins
    System.out.println("-------------\n");

    /* ***************************** Display Shopping Cart List ***************************** */
    /* ************************** Calculate Sum of Purchased Items ************************** */
    int count = 0;
    double sum = 0;
    double totalPrice = 0;

    for(Product txCode : shoppingCart) { // HINT: derived via ArrayList
      System.out.print(shoppingCart.get(count).toString());
      System.out.println("    " + "\t\t\t    " + String.format("$   %.2f", txCode.price()));

      sum += txCode.price();
      count++;
    } // end for each loop
    /* **************************** Show Tally of Purchased Items *************************** */
    totalPrice = sum;
    System.out.printf("Total pice: $%.2f\n", totalPrice);
    // Ask user to select an item to purchase
    System.out.printf("By which product? "); // Prompt user | System.out.printf("> Chose a number: ");
    Scanner number = new Scanner(System.in);

    do {

      try
      {
        input = Integer.parseInt(number.nextLine()); // Get input | num.nextInt();
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(-1);
      } // end try...catch
      if (input > 7) { /* If selection item# > +7, notify via IllegalArgumentException */
        throw new IllegalArgumentException("\nInvalid menu choice. Good bye!");
        /* code */
      } else if (input <= -1) { /* If item# < -1 (negative), then exit */
        System.out.printf("Good Bye!\n");
        System.out.printf("\n");
        System.exit(-1);
        /* code */
      } else { /* Otherwise return input */
        return input; // Escapes do..while loop
        /* code */
      } // end iffe

    } while (input < -1 || input > 7); // end do..while loop
    return input;

  } // end menu


  public void start() {
      // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
      // can now access non-static fields

      // Initialize | Equate variable to any alphabet char
      char choice = 'A';

      do {
        Scanner scanner = new Scanner(System.in);
        choice = (char)Menu();  // Get char input | ERROR prone: choice = scanner.next().charAt(0);

        System.out.printf("\n");
        switch (choice) { // (char vs int) - Slight conversion conflict
          case 0:
              System.out.println("Option 0: " + products.get(0).toString()); // Milk ($2.85)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(0));
              break;

          case 1: // Display: 2nd choice
              System.out.println("Option 1: " + products.get(1).toString()); // Bread ($1.99)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(1));
              break;

          case 2: // Display: 2nd choice
              System.out.println("Option 2: " + products.get(2).toString()); // Cheese ($0.85)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(2));
              break;

          case 3: // Display: 2nd choice
              System.out.println("Option 3: " + products.get(3).toString()); // Eggs ($6.95)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(3));
              break;

          case 4: // Display: 2nd choice
              System.out.println("Option 4: " + products.get(4).toString()); // Ice Cream ($4.95)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(4));
              break;

          case 5: // Display: 2nd choice
              System.out.println("Option 5: " + products.get(5).toString()); // Poptarts ($3.49)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(5));
              break;

          case 6: // Display: 2nd choice
              System.out.println("Option 6: " + products.get(6).toString()); // Oreos ($5.99)
              System.out.printf("\n");
              /* Input | Add to shoppingCart if selected */
              shoppingCart.add(products.get(6));
              break;

          case 7: // Gracefully terminate program
              System.out.printf("Good Bye!\n");
              System.out.printf("\n");
              System.exit(-1);
              break;

          default:
              System.out.printf("%s\n%s\n", "Invalid input!",
              "Please enter a number range (0 - 7).\n"); // Key selection is NOT an integer.
              break;
        } // end switch
        /* code */
      } while((choice != 7)); // end do..while |  || (choice != '4')

  } // end start()


  public static void main(String[] args) { // Function main() begins program execution

    Store store = new Store();
    store.start();

  } // end function main()
} // end class
