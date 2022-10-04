public class MixIn {

  // Constructor
  MixIn(MixInFlavor flavor, MixInAmount amount) {
    this.flavor = flavor;
    this.amount = amount;
  } // end Constructor

  @Override
  public String toString() {

    if (amount != (MixInAmount.Normal)) {
      return flavor + "(" + amount + ")";
    }
    else {
      return " " + flavor;
    } // end if else
  } // end toString

  // Two private Fields
  private MixInFlavor flavor;
  private MixInAmount amount;

}
