package emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import java.util.ArrayList;
import java.util.Arrays;

public class Emporium {

  // Fields of ArrayList
  private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
  private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
  private ArrayList<Scoop> scoops = new ArrayList<>();

  public void addMixInFlavor(MixInFlavor flavor) {
    mixInFlavors.add(flavor);
  }

  public void addIceCreamFlavor(IceCreamFlavor flavor) {
    iceCreamFlavors.add(flavor);
  }

  public void addScoop(Scoop scoop) {
    scoops.add(scoop);
  }

  /*   */
  public  Object[] mixInFlavors() {
    return this.mixInFlavors.toArray();
  }

  public  Object[] iceCreamFlavors() {
    return this.iceCreamFlavors.toArray();
  }
  
  public  Object[] scoops() {
    return this.scoops.toArray();
  }

} // end Emporium
