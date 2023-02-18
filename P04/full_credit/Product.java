
 abstract class Product {

   /* Throw a runtime exception if cost is negative.
    * throw new IllegalArgumentException("\nInvalid menu choice. Good bye!"); */
   // Constructor |||
   public Product(String name, double cost) {
     if(cost < 0) { // Validate or check data NOT negative
       throw new RuntimeException("Bad - cost is negative!");
     }
     this.name = name;
     this.cost = cost;
   }

   /* prc$ abstract (it has no implementation in this class).
    * It will be overridden in the subclasses.*/
   // Method
   public abstract double price(); // No implamentation

   @Override
   public String toString() { // Special functions
     return "" + name + " " + "($" + cost + ")";
   }

   // Fields
   protected double cost;
   protected String name;

 } // end class
