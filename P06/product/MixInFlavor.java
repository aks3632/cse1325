package product;

public class MixInFlavor extends Item {

  // Constructor
  public MixInFlavor (String name, String description, int cost, int price) {
    super(name, description, cost, price);
    /* Item = Superclass; therefore, see above */
  } // end MixInFlavor

}
