package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixInFlavor extends Item {

  // Constructor
  public MixInFlavor (String name, String description, int cost, int price) {
    super(name, description, cost, price);
    /* Item = Superclass; therefore, see above */
  } // end MixInFlavor

  // Professor's code
  public MixInFlavor(BufferedReader br) throws IOException {
      super(br);
  }

  // Professor's code
  public void save(BufferedWriter bw) throws IOException {
      super.save(bw);
  }

}
