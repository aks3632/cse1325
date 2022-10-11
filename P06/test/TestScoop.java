/***************************************************************************************
*    Title: MixIn
*    Author: George Rice
*    Date: 10/4/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
***************************************************************************************/

package test;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

/* Ali Senkayi */

public class TestScoop { // InteractiveTest


  private ArrayList<MixInFlavor> mixins = new ArrayList<>();
  private ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
  private ArrayList<Scoop> scoops = new ArrayList<>();

  /* Professor Rice's code */
  private Console console = System.console();

  /* Hint: Prof Swiped from Swing - MOST USEFUL!! */
  private int selectFromArray(String prompt, Object[] objects) {
      try {
          for(int i=0; i<objects.length; ++i)
              console.printf("%d) %s\n", i, objects[i].toString());
          return Integer.parseInt(console.readLine("\n%s ", prompt));
      } catch(Exception e) {
          System.err.println("#### Invalid selection, " + e);
          return -1;
      }
  }

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

  private void addScoop() {
      try {
              Scoop scoop = new Scoop(
                  flavors.get(selectFromArray("Flavor?", flavors.toArray())));
              String prompt = "Mixin? ";
              while(mixins.size() > 0) {
                  int mixinIndex = selectFromArray(prompt, mixins.toArray());
                  if(mixinIndex < 0) break;
                  int amount = selectFromArray("Amount?", MixInAmount.values());
                  if(amount < 0) break;
                  scoop.addMixIn(new MixIn(mixins.get(mixinIndex),
                                 MixInAmount.values()[amount]));
                  prompt = "Another mixin?";
              }
              console.printf("Adding %s\n", scoop.toString());
              scoops.add(scoop);
      } catch(Exception e) {
          System.err.println("#### Cancel scoop creation: " + e);
      }
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
        System.out.printf("3. (s)coop\n");
        System.out.printf("4. (q)uit?\n");
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

          case '2': // Display: 2nd choice
              System.out.printf("Option 2: Creating new Ice Cream Flavor!\n");
              System.out.printf("\n");
              addIceCreamFlavor(); /* << Professor Rice's code */
              break;

          case '3': // Display: 2nd choice
              System.out.printf("Option 3: Creating a scoop of ice cream!\n");
              System.out.printf("\n");
              addScoop(); /* << Professor Rice's code */
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

  // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
  public static void main(String[] args) { // function main begins program execution
    TestScoop testscoop = new TestScoop();
    testscoop.start();
  } // end main() 2

} // end TestScoop
