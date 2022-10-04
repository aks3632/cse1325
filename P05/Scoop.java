import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Scoop {

  // Constructoer - immediately follows
  public Scoop(IceCreamFlavor flavor) {
    this.flavor = flavor;
    this.mixins = new ArrayList<>();
  } // end Scoop

  // Method /* i = count of mix toppings */
  public void addMixIn(MixIn i) {
    mixins.add(i);
  }

  @Override
  public String toString() {
    return "" + flavor + "" + "With" + mixins;
  }

  // Fields
  private IceCreamFlavor flavor;
  private ArrayList<MixIn> mixins;
  // private ArrayList<MixIn> mixins = new ArrayList<>();

}

// Example:
// ArrayList<Vehicle> vehicles = new ArrayList<>();
