package product;

public class IceCreamFlavor extends Item {

  // Constructor
  public IceCreamFlavor (String name, String description, int cost, int price) {
    super(name, description, cost, price);
    /* Item = Superclass; therefore, see above */
  } // end IceCreamFlavor

  public IceCreamFlavor(BufferedReader br) throws IOException { // Professors code
      super(br);
  }

  public void save(BufferedWriter bw) throws IOException { // Professors code
      super.save(bw);
  }
}
