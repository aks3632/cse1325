package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {

  // Constructor 1
  public MixIn(MixInFlavor flavor, MixInAmount amount) {
    this.flavor = flavor;
    this.amount = amount;
  } // end Constructor

  // Constructor 2: Professor's code
  /* constructor (to read in your data) */
  public MixIn(BufferedReader br) throws IOException {
      amount = MixInAmount.valueOf(br.readLine());
      flavor = new MixInFlavor(br);
  }

  // Professor's code
  /* save method (to write out your data) */
  public void save(BufferedWriter bw) throws IOException {
      bw.write(amount.toString() + '\n');
      flavor.save(bw);
  }

  @Override
  public String toString() {

    /* Optional | Utilize ternary */
    /* return flavor.toString() + ((amount != MixInAmount.Normal) */
    if (amount != (MixInAmount.Normal)) {
      return flavor.toString() + "(" + amount + ")";
    }
    else {
      return " " + flavor.toString();
    } // end if else
  } // end toString

  // Two private Fields
  private MixInFlavor flavor; // private MixInFlavor flavor;
  private MixInAmount amount; // private MixInAmount amount;

} // end MixIn
