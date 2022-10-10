package product;

public class MixIn {

  // Constructor
  MixIn(MixInFlavor flavor, MixInAmount amount) {
    this.flavor = flavor;
    this.amount = amount;
  } // end Constructor

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
  private MixInFlavor flavor;
  private MixInAmount amount;

}
