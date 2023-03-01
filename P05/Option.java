 public class Option {

   // Fields
   protected String name;
   protected long cost;

   // Constructor
   /* ***Option instance with $0.00 cost MUST be supported | Option costInt = new Option(); */
   /* ^^Constructor Option in class Option cannot be applied to given types;^^ */
   public Option(String name, long cost) {
     if(cost < 0) { // Validate or check data NOT negative
       throw new IllegalArgumentException("Bad - negative cost for " + name + ": " + cost + "!");
     }
     this.name = name;
     this.cost = cost;
   } // end Constructor

   // Methods
   public long cost() { // Divide by 100 when printing
     try {
       // BTY, cost is the number of cents, not dollars,
       // so divide by 100.0 when printing.
       this.cost /= 100; // Observe

     } catch(Exception e) {
       System.err.println("Ending Program: " + e.getMessage());
       System.exit(-1);
     } // end try-catch

     return cost; // ** TestPt ~ Resolved
   } // end cost

   // Method
   @Override
   public String toString() {


     // Ex) "PNY CS900 500GB Internal SSD SATA ($29.99)"
     return "" + name + " " + "($" + cost + ")"; // Trial Run
   } // end toString

   /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */
   /* complex04 - complex07 | ~/cse1325-prof/04/code_from_slides/complex04 */
   @Override
   public boolean equals(Object o) {
     if(o == this) return true;                     // (1) An object is equal to itself
     if(!(o instanceof Option)) return false;       // (2) A different type is not equal
     Option c = (Option)o;                          // (3) Cast
     return (name.equals(c.name)) && Long.valueOf(cost).equals(Long.valueOf(c.cost)); // (4) Compare two name & cost |?
     // member Method valueOf(cost) | Converts String |& Returns Integer(Object)
   } // end equals

 } // end class

 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Option.java,
 * Author:
 * Created on: Feb 25, 2023 3:40 AM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /******************************************************************************
 Java Programming Tutorial 13 - Numeric Methods (max, compare, valueOf, parseInt, etc)
 *******************************************************************************/
