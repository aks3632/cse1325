
 public class Taxfree extends Product{

   // Constructor
   public Taxfree(String name, double cost) {
     super(name, cost); // Constuctors never inherit; therfore, chain to
                        // superclass constructor via invoke super()
   }

   @Override
   public double price() {
     return 1.0 * cost; // Test pt!
   }
 }
