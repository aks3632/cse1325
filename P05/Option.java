 public class Option {
   // Fields
   protected String name;
   protected long cost;

   // Constructor
   public Option(String name, long cost) {
     if(cost < 0) { // Validate or check data NOT negative
       throw new RuntimeException("Bad - cost is negative!");
     }
     this.name = name;
     this.cost = cost;
   } // end Constructor

   // Methods
   public long cost() { // Divide by 100 when printing
     return 1; // ** Missing Return
   } // end cost

   // Method
   @Override
   public String toString() {
     // Ex) "PNY CS900 500GB Internal SSD SATA ($29.99)"
     return "" + name + " " + "($" + cost/100 + ")"; // Trial Run
   } // end toString

   /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */
   @Override
   public boolean equals(Object o) {
     return true; // ** Missing Return
   } // end equals

 } // end class

 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Customer.java,
 * Author:
 * Created on: Feb 25, 2023 3:40 AM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /******************************************************************************
 Java Programming Tutorial 62 - Encapsulation (Lecture)
 Java Programming Tutorial 63 - Create a Getter
 *******************************************************************************/
