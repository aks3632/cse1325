package emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;

public class Emporium {
  // Constructor usualy initializes attributes
  public Emporium() {} // Empty constructor

  // Constructor 2: Professor's code
  /* constructor (to read in your data) */
  public Emporium(BufferedReader br) throws IOException {
      int size = Integer.parseInt(br.readLine());
      while(size-- > 0) mixInFlavors.add(new MixInFlavor(br));

      size = Integer.parseInt(br.readLine());
      while(size-- > 0) iceCreamFlavors.add(new IceCreamFlavor(br));

      size = Integer.parseInt(br.readLine());
      while(size-- > 0) scoops.add(new Scoop(br));
  }

  // Professor's code
  /* save method (to write out your data) */
  public void save(BufferedWriter bw) throws IOException {
      bw.write("" + mixInFlavors.size() + '\n');
      for(MixInFlavor mif : mixInFlavors) mif.save(bw);

      bw.write("" + iceCreamFlavors.size() + '\n');
      for(IceCreamFlavor icf : iceCreamFlavors) icf.save(bw);

      bw.write("" + scoops.size() + '\n');
      for(Scoop s : scoops) s.save(bw);
  }

  public void addMixInFlavor(MixInFlavor flavor) {
    mixInFlavors.add(flavor);
  }

  public void addIceCreamFlavor(IceCreamFlavor flavor) {
    iceCreamFlavors.add(flavor);
  }

  public void addScoop(Scoop scoop) {
    scoops.add(scoop);
  }

  public  Object[] mixInFlavors() {
    return this.mixInFlavors.toArray();
  }

  public  Object[] iceCreamFlavors() {
    return this.iceCreamFlavors.toArray();
  }

  public  Object[] scoops() {
    return this.scoops.toArray();
  }

  // Fields of ArrayList
  private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
  private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
  private ArrayList<Scoop> scoops = new ArrayList<>();
} // end Emporium
