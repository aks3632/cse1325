package product;

public class MixIn {

  // Constructor
  public MixIn(MixInFlavor flavor, MixInAmount amount) {
    this.flavor = flavor;
    this.amount = amount;
  } // end Constructor

  // Professor's code
  public MixIn(BufferedReader br) throws IOException {
      amount = MixInAmount.valueOf(br.readLine());
      flavor = new MixInFlavor(br);
  }

  // Professor's code  
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
