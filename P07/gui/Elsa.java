package gui;

import javax.swing.SwingUtilities;

public class Elsa {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
          new MainWin("ELSA");
          } // end run
        }); // end SwingUtilities
    } // end main()
} // end class
