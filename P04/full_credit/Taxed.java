
public class Taxed extends Product {

  // Constructor
  public Taxed(String name, double cost) {
    super(name, cost);  // Constuctors never inherit; therfore, chain to
                        // superclass constructor via invoke super()
  }

  // Methods
  public static void setTaxRate(double salesTax) { // VOID!!!
    // return? Answer NO, because Method is static
    salesTaxRate = salesTax;
  }

  // Any class derived from Product must @Override and
  // and implement price() before it can be instanced
  @Override
  public double price() {
    return cost * (1 + salesTaxRate); // Test pt!
  }

  // Field
  private static double tax; // salesTaxRate???
  public static double salesTaxRate = 0.0;  // salesTax

}
