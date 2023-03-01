import java.util.ArrayList;
import java.util.Arrays;

 public class Computer {

   // Fields - ArrayList<Option> Declerated & Initialized outside methods!
   private String name;
   private String model;
   private ArrayList<Option> options = new ArrayList<>();

   // Constructor - No data validation required here!
   Computer(String name, String model) {
     this.name = name;
     this.model = model;
   } // end Constructor

   // Method
   /* addOption method simply adds its parameter to the options field */
   public void addOption(Option option) {
     options.add(option);
   } // end addOption

   // Method
   /* Returns the sum of the cost of each Option in the options ArrayList */
   public long cost() {
     long sum = 0;
     long totalCost = 0;

     for(Option smpCost : options) {
       sum += smpCost.cost();
     } // end for:each loop
     return totalCost = sum;
   } // end cost

   /* Ex)
   SuperCalc (1Z200XL)
      Mainboard ($195.99)
      RAM ($93.28)
      SSD ($55.00)
      Case ($39.00) */
   @Override
   public String toString() { // ** OK (Close to accurate)
     // Resolved | How to iterate via Options (parts) & return

     StringBuilder result = new StringBuilder("" + String.format("$ %s\n", options.toString()));
     // StringBuilder is preferred here over String because we're building up
     // a String in a loop. Remember, String is immutable - every change
     // you make creates an entire new object! StringBuider is mutable.

     /* for:each loop | Naturally pans through entire ArrayList! */
     int i = 0; // index count for option items
     for(Option smpParts : options) {
       result.append("" + String.format("$ %s\n", options.get(i).toString()));
       i++;
     } // end for:each loop

     return "" + name + " " + "(" + model + ")" + "\n"
            + "\t\t"
            + result.toString(); // ** OK
   } // end toString

   @Override
   public boolean equals(Object o) {
     if(o == this) return true;                         // (1) An object is equal to itself
     if(!(o instanceof Computer)) return false;         // (2) A different type is not equal
     Computer c = (Computer)o;                          // (3) Cast
     return ((name.equals(c.name))
            && (model.equals(c.model)))
            && options.toString().equals(c.options.toString()); // (4) Compare three name, model and options.toString() |?
   } // end equals | HINT: OPTION = NAME + COST via toString
   /* complex04 - complex07 | ~/cse1325-prof/04/code_from_slides/complex04 */
   /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */

 } // end Computer class

 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Computer.java,
 * Author:
 * Created on: Feb 25, 2023 10:25 PM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /******************************************************************************
 Java Programming Tutorial 62 - Encapsulation (Lecture)
 Java Programming Tutorial 63 - Create a Getter
 *******************************************************************************/
