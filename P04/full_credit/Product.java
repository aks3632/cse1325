
 public abstract class Product {

   // Constructor
   public Product(String name, double cost) {
     this.name = name;
     this.cost = cost;
   }

   // Method
   public abstract double price(); // No implamentation

   @Override
   public String toString() { // Special functions

     return " ";
   }

   // Fields
   protected double cost;
   protected String name;

 } // end class
