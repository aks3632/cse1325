/* ==========================================================================
*    Title: MixIn
*    Author: George Rice
*    Date: 10/4/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
========================================================================== */

package product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Scoop {

  // Constructer - immediately follows
  public Scoop(IceCreamFlavor flavor) {
    this.flavor = flavor;
    this.mixins = new ArrayList<>();
  } // end Constructer Scoop


  // Professor's code
  public Scoop(BufferedReader br) throws IOException {
      this.flavor = new IceCreamFlavor(br);
      this.mixins = new ArrayList<>();
      int numMixIns = Integer.parseInt(br.readLine());
      while(numMixIns-- > 0) mixins.add(new MixIn(br));
  }

  // Professor's code
  public void save(BufferedWriter bw) throws IOException {
      flavor.save(bw);
      bw.write("" + mixins.size() + '\n');
      for(MixIn mi : mixins) mi.save(bw);
  }

  // Method | i = count of mix toppings
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
  }  /* ^^Professor Rice's code */

  // Fields
  private IceCreamFlavor flavor; // private IceCreamFlavor flavor;
  private ArrayList<MixIn> mixins; // private ArrayList<MixIn> mixins;
  // Example: private ArrayList<MixIn> mixins = new ArrayList<>();
} // end Scoop
