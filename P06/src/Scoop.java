import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


public class Scoop {

  // Constructoer - immediately follows
  public Scoop(IceCreamFlavor flavor) {
    this.flavor = flavor;
    this.mixins = new ArrayList<>();
  } // end Scoop

  // Method /* i = count of mix toppings */
  public void addMixIn(MixIn mixin) {
    mixins.add(mixin); // OR push info onto ArrayList
  }

  /* Professor Rice's code */
  @Override
  public String toString() {
      StringBuilder result = new StringBuilder(flavor.toString());
      if(mixins.size() > 0) {
          String separator = " with ";
          for(MixIn m : mixins) {
              result.append(separator + m.toString());
              separator = ", ";
          }
      }
      return result.toString();
  }
  /* ^^Professor Rice's code */

  // Fields
  private IceCreamFlavor flavor;
  private ArrayList<MixIn> mixins;
  // private ArrayList<MixIn> mixins = new ArrayList<>();

}

// Example:
// ArrayList<Vehicle> vehicles = new ArrayList<>();
