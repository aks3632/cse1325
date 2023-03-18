package gui;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons
import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Boolean;

import store.Computer;
import store.Customer;
import store.Option;
import store.Order;
import store.Store;
import store.TestStore;


public class MainWin extends JFrame {

  /* Professor's code - PATTERN REGEX E-MAIL | ~ "Not working" | ^([a-zA-Z0-9_-.]+)@([a-zA-Z0-9_-.]+).([a-zA-Z]{2,5})$ */
  /* Utilized geeksforgeeks GOOD REGEX pattern for convenience | https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
  public static final String PTTNREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

  // Option Two: add overriding properties to your enums if you want more control
  public enum Modes { // https://stackoverflow.com/questions/6667243/using-enum-values-as-string-literals
    mode1("Customers"),
    mode2("Options"),
    mode3("Computers");

    private String label;

    private Modes(String mode) {
        this.label = mode;
    }
    public String getLabel() {
       return label;
    }
  };


  public MainWin(String title) { // ** Constructor
      super(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 200);

      // /////// ////////////////////////////////////////////////////////////////
      // M E N U
      // Add a menu bar to the PAGE_START area of the Border Layout

      JMenuBar menubar = new JMenuBar();

      JMenu     file       = new JMenu("File");
      /* ***************************** NEW MENU ***************************** */
      /* ***************************** NEW MENU ***************************** */
      JMenuItem quit       = new JMenuItem("Quit");
      /* ***************************** NEW MENU ***************************** */
      /* ***************************** NEW MENU ***************************** */
      JMenu     insert           = new JMenu("Insert");
      JMenuItem insertCustomer   = new JMenuItem("Customer");
      JMenuItem insertOption     = new JMenuItem("Option");
      JMenuItem insertComputer   = new JMenuItem("Computer");
      JMenu     view             = new JMenu("View");
      JMenuItem viewCustomers    = new JMenuItem(Modes.mode1.getLabel()); // "Customers"
      JMenuItem viewOptions      = new JMenuItem(Modes.mode2.getLabel()); // "Options"
      JMenuItem viewComputers    = new JMenuItem(Modes.mode3.getLabel()); // "Computers"
      JMenu     help             = new JMenu("Help");
      JMenuItem about            = new JMenuItem("About");

      quit            .addActionListener(event -> onQuitClick());                 // OK
      /* ************************** ACTION LISTNER ************************** */
      /* ************************** ACTION LISTNER ************************** */
      insertCustomer  .addActionListener(event -> onInsertCustomerClick());       // OK
      insertOption    .addActionListener(event -> onInsertOptionClick());         // OK
      insertComputer  .addActionListener(event -> onInsertComputerClick());       // OK
      viewCustomers   .addActionListener(event -> onViewClick(Record.CUSTOMER));  // OK
      viewOptions     .addActionListener(event -> onViewClick(Record.OPTION));    // OK
      viewComputers   .addActionListener(event -> onViewClick(Record.COMPUTER));  // OK
      about.addActionListener(event -> onAboutClick());


      file.add(quit);
      /* ******************************* FILE ******************************* */
      /* ******************************* FILE ******************************* */
      insert.add(insertCustomer); // OK
      insert.add(insertOption);   // OK
      insert.add(insertComputer); // OK
      view.add(viewCustomers);    // OK
      view.add(viewOptions);      // OK
      view.add(viewComputers);    // OK
      help.add(about);

      menubar.add(file);
      menubar.add(insert);        // OK
      menubar.add(view);          // OK
      menubar.add(help);

      setJMenuBar(menubar);


      // ///////////// //////////////////////////////////////////////////////////
      // T O O L B A R
      // Add a toolbar to the PAGE_START region below the menu
      JToolBar toolbar = new JToolBar("ELSA Controls");

      // A "horizontal strut" is just a space of the specified pixel width
      toolbar.add(Box.createHorizontalStrut(25));

      // Create the 3 buttons using the icons provided | Naming scheme of buttons is consistant
      // <a href="https://www.flaticon.com/free-icons/user" title="user icons">User icons created by Freepik - Flaticon</a>
      JButton buttonAddCust = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/add_user.png"));
        buttonAddCust.setActionCommand("Insert Customer");
        buttonAddCust.setToolTipText("Insert Customer");
        JLabel plus = new JLabel(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/plus.png"));
        plus.setBounds(0,0,50,50);
        toolbar.add(buttonAddCust, plus);
        buttonAddCust.addActionListener(event -> onInsertCustomerClick());

      JButton buttonAddOpt = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/add_chip.png"));
        buttonAddOpt.setActionCommand("Insert Options");
        buttonAddOpt.setToolTipText("Insert Options");
        toolbar.add(buttonAddOpt);
        buttonAddOpt.addActionListener(event -> onInsertOptionClick());

      // <a href="https://www.flaticon.com/free-icons/laptop" title="laptop icons">Laptop icons created by Freepik - Flaticon</a>
      JButton buttonAddComp = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/add_laptop.png"));
        buttonAddComp.setActionCommand("Insert Computer");
        buttonAddComp.setToolTipText("Insert Computer");
        toolbar.add(buttonAddComp);
        buttonAddComp.addActionListener(event -> onInsertComputerClick());

      toolbar.add(Box.createHorizontalStrut(25));

      // Create the 3 buttons using the icons provided | Naming scheme of buttons is consistant
      // <a href="https://www.flaticon.com/free-icons/leadership" title="leadership icons">Leadership icons created by Vectors Tank - Flaticon</a>
      JButton buttonViewCusts = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/view_clients.png"));
        buttonViewCusts.setActionCommand("View Customers");
        buttonViewCusts.setToolTipText("View Customers");
        toolbar.add(buttonViewCusts);
        buttonViewCusts.addActionListener(event -> onViewClick(Record.CUSTOMER));

      JButton buttonViewOpts = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/view_networks.png"));
        buttonViewOpts.setActionCommand("View Options");
        buttonViewOpts.setToolTipText("View Options");
        toolbar.add(buttonViewOpts);
        buttonViewOpts.addActionListener(event -> onViewClick(Record.OPTION));

      // <a href="https://www.flaticon.com/free-icons/computers" title="computers icons">Computers icons created by Freepik - Flaticon</a>
      JButton buttonViewComps = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/view_computers.png"));
        buttonViewComps.setActionCommand("View Computers");
        buttonViewComps.setToolTipText("View Computers");
        toolbar.add(buttonViewComps);
        buttonViewComps.addActionListener(event -> onViewClick(Record.COMPUTER));


      // "Horizontal glue" expands as much as possible, pushing the "X" to the right
      toolbar.add(Box.createHorizontalGlue());

      // Create a custom Quit button (not available in Swing stock icons)
      JButton quitB  = new JButton("X");
        quitB.setActionCommand("Quit");
        quitB.setToolTipText("Exit game");
        quitB.setBorder(null);
        toolbar.add(quitB);
        quitB.addActionListener(event -> onQuitClick());
      toolbar.addSeparator();

      getContentPane().add(toolbar, BorderLayout.PAGE_START);


      // /////////////////////////// ////////////////////////////////////////////
      // D I S P L A Y
      // Provide a text entry box to show the remaining sticks
      display = new JLabel();
      display.setFont(new Font("Courier New", Font.BOLD, 18));
      display.setVerticalAlignment(JLabel.TOP);
      add(display, BorderLayout.CENTER);

      // Make everything in the JFrame visible
      setVisible(true);

      // Start a new store
      store = new Store("ELSA Prime");  // Instance a new Store

  } // END CONSTRUCTOR

  /* ************************************* END CONSTRUCTOR ************************************* */

  static void checkEmail(String email) {
    if(isVAV(email) == false) {
      throw new IllegalArgumentException("\nInvalid email: " + String.format("%s %s\n", email, "Good Bye!"));
    } else {
      System.out.println("Access granted: " + email + " is valid");
    } // end ife
  } // end checkEmail

  /* ****************************************** REGEX ****************************************** */

  /* https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
  /* https://www.tutorialspoint.com/java/java_regular_expressions.htm */
  public static boolean isVAV(String email) {

   Pattern pattnSeq = Pattern.compile(PTTNREGEX, Pattern.CASE_INSENSITIVE); // TestPt extra parameter
   if(email == null) { // **1st | (Once): Validate or check data NOT invalid e-mail
     return false;
   } // end if
   return pattnSeq.matcher(email).matches();
  } // end isVAV

  /* ****************************************** REGEX ****************************************** */

  // Listeners

  protected void onAboutClick() { // Display About dialog
      JLabel logo = null;
      try {
          BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
          logo = new JLabel(new ImageIcon(myPicture));
      } catch(IOException e) {
      }

      JLabel title = new JLabel("<html>"
        + "<p><font size=+4>ELSA</font></p>"
        + "</html>",
        SwingConstants.CENTER);

      JLabel subtitle = new JLabel("<html>"
        + "<P>Exceptional Laptops and Supercomputers Always</p>"
        + "</html>",
        SwingConstants.CENTER);

      JLabel version = new JLabel("<html>"
        + "<p>Version 0.2J</p>"
        + "</html>",
        + SwingConstants.CENTER);

      JLabel artists = new JLabel("<html>"
        + "<br><p> Ali Senkayi (aks3632@mavs.uta.edu)</p>"
        + "<p>CSE 1325-001-Object Oriented Programming</p></br>"

        + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
        + "<p>Licensed under Gnu GPL 3.0</p><br/>"

        + "<p>[xx_Image] by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
        + "<p><font size=-2>https://www.flaticon.com/</font></p>"

        + "<br/><p>Add Customer icon based on work created by Freepik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/user title=user icons</font></p><br/>"

        + "<br/><p>View Customers icon based on work created by Vectors Tank per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/leadership title=leadership icons</font></p><br/>"

        + "<br/><p>Add Option icon based on work created by ~ xx_N/A per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/ ~ title=xx_N/A_add_chip</font></p><br/>"

        + "<br/><p>View Options icon based on work created by ~ xx_N/A per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/ ~ title=xx_N/A_view_networks icons</font></p><br/>"

        + "<br/><p>Add Computer icon based on work created by Freepik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/laptop title=laptop icons</font></p><br/>"

        + "<br/><p>View Computers icon based on work created by Freepik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/computers title=computers icons</font></p><br/>"
        + "</html>");

       JOptionPane.showMessageDialog(this,
           new Object[]{logo, title, subtitle, version, artists},
           "ELSA",
           JOptionPane.PLAIN_MESSAGE
       );
   }

   /* ****************** START NEW LISTNERS PROTECTED ****************** */

   String name;
   String email;
   long cost;

   protected void onInsertCustomerClick() { // Revised to Professor's code | NullPointerException
     try {
         name = JOptionPane.showInputDialog(this, "Customer Name", "New Customer", JOptionPane.PLAIN_MESSAGE);
         email = JOptionPane.showInputDialog(this, "Customer e-mail", "New Customer", JOptionPane.PLAIN_MESSAGE);
         checkEmail(email);
         Customer customer = new Customer(name, email); // Customer constructor
         store.add(customer);           // Pass new Customer to Store's add method
         onViewClick(Record.CUSTOMER);  // Invoke call

     } catch(NullPointerException e) {
     } catch(Exception e) {
         JOptionPane.showMessageDialog(this, e,
             "Customer Not Created", JOptionPane.ERROR_MESSAGE);
         System.err.println(e.getMessage());
         // System.exit(-1); | Avoid exiting program
     } // end try-catch
   } // end onInsertCustomerClick()

   protected void onInsertOptionClick() {
     try {
         int places = 3;
         double scale = Math.pow(10, places);

         JLabel name = new JLabel("<HTML><br/>Option Name</HTML>");
         names = new JTextField(20);

         JLabel cost = new JLabel("<HTML><br/>Option Cost</HTML>");
         costs = new JTextField(20);

         // Display the dialog
         // ~/cse1325-prof/13/code_from_slides/AnimalJOptionPane.java
         Object[] objects = {  // Array of widgets to display
             cost,   costs,
             name,   names};
         int button = JOptionPane.showConfirmDialog( // Show the dialog
             this,                          // Component parentComponent
             objects,                       // Object message
             "New Cost of Options Parts",           // [String title
             JOptionPane.OK_CANCEL_OPTION,  // int optionType | OK_CANCEL_OPTION
             JOptionPane.QUESTION_MESSAGE,  // [int messageType | QUESTION_MESSAGE
             null);                         // [Icon icon]
         if(button == JOptionPane.OK_OPTION)  // If OK clicked, show data | responseType: OK_OPTION
         JOptionPane.showMessageDialog(
             this,
             names.getText() + " ("+ (long)(100 * (Math.round((Double.valueOf(costs.getText())) * scale) / scale)) + ")" );
             // (A) https://stackoverflow.com/questions/36604943/how-do-i-convert-a-jtextfield-string-to-a-double
             // (1) Double.valueOf(costs.getText())      | Converts String |& Returns Integer(Object)
             // (2) Double.parseDouble(costs.getText())  | Converst String |& Returns int (Primitive)
             // (B) https://www.baeldung.com/java-round-decimal-number
             // (3) Math.round(value * scale) / scale    | Truncates value
          String str1 = names.getText();
          long num1 = (long)(100 * (Math.round((Double.valueOf(costs.getText())) * scale) / scale));
          Option option = new Option(str1, num1); // Option constructor
          store.add(option);          // Pass new Option to Store's add method
          onViewClick(Record.OPTION); // Invoke call
     } catch(NullPointerException e) {
     } catch(Exception e) {
          JOptionPane.showMessageDialog(this, e,
              "Customer Not Created", JOptionPane.ERROR_MESSAGE);
          System.err.println(e.getMessage());
     } // end try-catch
   } // end onInsertOptionClick()

   protected void onInsertComputerClick() {
     try {
         JLabel name = new JLabel("<HTML><br/>Name</HTML>");
         names = new JTextField(20);

         JLabel model = new JLabel("<HTML><br/>Model</HTML>");
         models = new JTextField(20);

         Object[] objects1 = { // Array of widgets to display
             name, names,
             model, models};
         int button1 = JOptionPane.showConfirmDialog(
             this,                              // Component parentComponent
             objects1,                          // Object message
             "New Computer",                    // [String title
             JOptionPane.OK_CANCEL_OPTION,      // int optionType
             JOptionPane.QUESTION_MESSAGE,      // [int messageType,
             null);                             // [Icon icon]
          String str2 = names.getText();
          String str3 = models.getText();
          Computer computer = new Computer(str2, str3); // Computer constructor

          JLabel compOpt = new JLabel("Computer Options");
          // (A) Obtain an Object[] array of Option objects from store
          // (1) Store.java | public Object[] options() { etc...
          // (B) Instance a JComboBox,
          // (1) Pass the Object[] array retrieved from store as the constructor parameter
          // Object[] options = {store.options()};            // A | 1
          compOpts = new JComboBox<Object>(store.options());  // B | 1

          int optionsAdded = 0; // Don't add computers with no options
          Object data;
          Object[] objects2 = { // An Array of widget to display
              compOpt, compOpts};
          do {  // Revised to Professor's code
            int button2 = JOptionPane.showConfirmDialog(
                this,                         // Component parentComponent
                objects2,                     // Object message
                "Another Option?",            // [String title
                JOptionPane.YES_NO_OPTION);   // int optionType
                //JOptionPane.PLAIN_MESSAGE,    // [int messageType,
                //null);                        // [Icon icon]

            /* User selects an Option via JComboBox */
            /* JComboBox's getSelectedItem() method obtains data */
            data = compOpts.getSelectedItem();

            if(button2 != JOptionPane.YES_OPTION) break;  // If button clicked, NOT EQUAL, then break | responseType: YES_OPTION
            computer.addOption((Option) data);            // Cast converts Object to Option
            ++optionsAdded;                               // button2 equals YES_OPTION; therefore, continue ++count
          } while (true); // end do-while(true)
          if(optionsAdded > 0) {
            store.add(computer);  // Pass the Computer object built up to store's add method
            onViewClick(Record.COMPUTER); // Invoke call
          } // end if
     } catch(NullPointerException e) {
     } catch(Exception e) {
         JOptionPane.showMessageDialog(this, e,
             "Computer Not Created", JOptionPane.ERROR_MESSAGE);
         System.err.println(e.getMessage());
         // System.exit(-1); | Avoid exiting program
     } // end try-catch
   } // end onInsertComputerClick() |  ^^ Revised to Professor's code ^^

   protected void onViewClick(Record record) {  // >> Professor's code <<
     String header = null;
     Object[] list = null;

     switch (record.asInt()) {
       case 1:  // CUSTOMER if record == Record.CUSTOMER
          header = "Our Beloved Customers";
          list = store.customers();
          break;
       case 2:  // OPTION if record == Record.OPTION
          header = "Options for our SuperComputers";
          list = store.options();
          break;
       case 3:  // COMPUTER if record == Record.COMPUTER
          header = "Computers for Sale - Cheap!";
          list = store.computers();
          break;
       case 4:  // Order if record == Record.ORDER
          header = "Orders Placed to Date";
          list = store.orders();
          break;
     } // end switch
     StringBuilder sb = new StringBuilder("<html><p><font size=+2>"
                 + header + "</font><p></br>\n<ol>\n");
     for(Object i : list) sb.append("<li>" + i.toString().replaceAll("<","&lt;")
                                                         .replaceAll(">", "&gt;")
                                                         .replaceAll("\n", "<br/>") + "</li>\n");
     sb.append("<ol></html>");
     display.setText(sb.toString());
   } // end onViewClick(Record record) | ^^ Revised to Professor's code ^^

   private enum Record {CUSTOMER(1), OPTION(2), COMPUTER(3), ORDER(4);

       // Attribute for the integer representing this record
       private final int recordID;

       // Constructor for setting the attribute
       private Record(int recordID) {
         this.recordID = recordID;
       }

       // Method that returns the associated record ID sequence for a specific record
       public int asInt() {
         return recordID;
       }
   } // enum - Type
   // Display from 2021 Maybe?

   /* ******************* END NEW LISTNERS PROTECTED ******************* */

  protected void onQuitClick() {System.exit(0);}   // Exit the game


  private Store store;                  // New Store
  private JLabel display;               // Main data display
  private JLabel response;              // N/A
  private JTextField names;             // name of parts
  private JTextField costs;             // cost
  private JComboBox<Object> compOpts;   // JComboBox via Computer Options
  private JTextField models;            // model

  private JButton buttonAddCust;        // Button to select 1
  private JButton buttonAddOpt;         // Button to select 2
  private JButton buttonAddComp;        // Button to select 3
  private JButton buttonViewCusts;      // Button to select 4
  private JButton buttonViewOpts;       // Button to select 5
  private JButton buttonViewComps;      // Button to select 6

} // end class MainWin

/******************************************************************************

* CSE 1320-001 Spring 2023
* File: Option.java,
* Author:
* Created on: Feb 25, 2023 3:40 AM
.*
* UTA Student Name:
* UTA ID:

*******************************************************************************/

/******************************************************************************
member Method valueOf(cost) | Converts String |& Returns Integer(Object)
Java Programming Tutorial 13 - Numeric Methods (max, compare, valueOf, parseInt, etc)
*******************************************************************************/
