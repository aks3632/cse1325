import test.TestScoop;
import gui.MainWin;
import product.AboutDialog;
import product.Nim;
import emporium.Emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

public class MICE {
  // https://stackoverflow.com/questions/2559527/non-static-variable-cannot-be-referenced-from-a-static-context
  public static void main(String[] args) { // function main begins program execution

    /* ********* OK - Trial Runs *********
    TestScoop testscoop = new TestScoop();
    testscoop.start();
    *********************************** */

    MainWin myApp = new MainWin("Mavs Ice Cream Emporium");
    myApp.setVisible(true);

  } // end main() 1

} // emd MICE
