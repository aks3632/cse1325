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

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file
import java.io.BufferedReader;
import java.io.FileReader;
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
import gui.art.Line;
import gui.art.Canvas;
import gui.art.Spirograph;


public class MainWin extends JFrame {

  /* Professor's code - PATTERN REGEX E-MAIL | ~ "Not working" | ^([a-zA-Z0-9_-.]+)@([a-zA-Z0-9_-.]+).([a-zA-Z]{2,5})$ */
  /* Utilized geeksforgeeks GOOD REGEX pattern for convenience | https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
  public static final String PTTNREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

  // Option Two: add overriding properties to your enums if you want more control
  public enum Modes { // https://stackoverflow.com/questions/6667243/using-enum-values-as-string-literals
    mode1("Customers"),
    mode2("Options"),
    mode3("Computers"),
    mode4("Orders");


    private String label;

    private Modes(String mode) {
        this.label = mode;
    }
    public String getLabel() {
       return label;
    }
  };

  private String NAME = "Elsa";
  private String VERSION = "1.4J";
  private String FILE_VERSION = "1.0";
  private String MAGIC_COOKIE = "Store☏"; // White Telephone | https://www.hotsymbol.com/symbol/white-telephone
  private final String DEFAULT_STORE_NAME = "New " + NAME + " Store";

  public MainWin(String title) { // ** Constructor
      super(title);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(400, 200);
      filename = new File("untitled.ppm"); // Replace untitled.nim with ext. *.ppm (parts per million)

      // /////// ////////////////////////////////////////////////////////////////
      // M E N U
      // Add a menu bar to the PAGE_START area of the Border Layout

      JMenuBar menubar = new JMenuBar();

      JMenu     file             = new JMenu("File");
      /* ***************************** NEW MENU ***************************** */
      JMenuItem anew             = new JMenuItem("New File");           // A-New
      JMenuItem open             = new JMenuItem("Open");                 // Open - JFileChooser | GOOD
                save             = new JMenuItem("Save");                 // Save
                saveAs           = new JMenuItem("Save As");              // Save As - JFileChooser
      /* ***************************** OPEN/SAVE **************************** */
      JMenuItem quit             = new JMenuItem("Quit");
      JMenu     insert           = new JMenu("Insert");
      JMenuItem insertCustomer   = new JMenuItem("Customer");
      JMenuItem insertOption     = new JMenuItem("Option");
      JMenuItem insertComputer   = new JMenuItem("Computer");
      JMenuItem insertOrder      = new JMenuItem("Order");
      JMenu     view             = new JMenu("View");
      JMenuItem viewCustomers    = new JMenuItem(Modes.mode1.getLabel()); // "Customers"
      JMenuItem viewOptions      = new JMenuItem(Modes.mode2.getLabel()); // "Options"
      JMenuItem viewComputers    = new JMenuItem(Modes.mode3.getLabel()); // "Computers"
      JMenuItem viewOrders       = new JMenuItem(Modes.mode4.getLabel()); // "Orders"
      JMenu     help             = new JMenu("Help");
      JMenuItem about            = new JMenuItem("About");

      /* ************************** ACTION LISTNER ************************** */
      anew            .addActionListener(event -> onNewClick());          // onNewClick() creates a new file | store = new Store
      open            .addActionListener(event -> onOpenClick());         // Open - JFileChooser
      save            .addActionListener(event -> onSaveClick());         // Save
      saveAs          .addActionListener(event -> onSaveAsClick());       // Save As - JFileChooser
      /* ************************** ACTION LISTNER ************************** */
      quit            .addActionListener(event -> onQuitClick());                 // OK
      insertCustomer  .addActionListener(event -> onInsertCustomerClick());       // OK
      insertOption    .addActionListener(event -> onInsertOptionClick());         // OK
      insertComputer  .addActionListener(event -> onInsertComputerClick());       // OK
      insertOrder     .addActionListener(event -> onInsertOrderClick());       // OK
      viewCustomers   .addActionListener(event -> onViewClick(Record.CUSTOMER));  // OK
      viewOptions     .addActionListener(event -> onViewClick(Record.OPTION));    // OK
      viewComputers   .addActionListener(event -> onViewClick(Record.COMPUTER));  // OK
      viewOrders      .addActionListener(event -> onViewClick(Record.ORDER));  // OK
      about           .addActionListener(event -> onAboutClick());


      /* ******************************* FILE ******************************* */
      file.add(anew);     // A-New
      file.add(open);     // Open
      file.add(save);     // Save
      file.add(saveAs);   // Save As
      /* ******************************* FILE ******************************* */
      file.add(quit);
      insert.add(insertCustomer); // OK
      insert.add(insertOption);   // OK
      insert.add(insertComputer); // OK
      insert.add(insertOrder); // OK
      view.add(viewCustomers);    // OK
      view.add(viewOptions);      // OK
      view.add(viewComputers);    // OK
      view.add(viewOrders);    // OK
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

      // [OR] Replace ImageIcon([String filename, [String description]]) with UIManager.getIcon("FileView.fileIcon")
      JButton anewB  = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/new_Document.png"));
        anewB.setActionCommand("New File");         // Designates name/word/title on button
        anewB.setToolTipText("Create a New File for New Merchant"); // Hovering over button displays silhouette text description
        anewB.setBorder(null);
        toolbar.add(anewB);
        anewB.addActionListener(event -> onNewClick());

      // A "horizontal strut" is just a space of the specified pixel width
      toolbar.add(Box.createHorizontalStrut(25));

      JButton buttonOpen = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/openFile-management.png"));
        buttonOpen.setActionCommand("Open File");   // Designates name/word/title on button
        buttonOpen.setToolTipText("Open File");     // Hovering over button displays silhouette text description
        toolbar.add(buttonOpen);  // Add to toolbar
        buttonOpen.addActionListener(event -> onOpenClick());

      buttonSave = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/saveFile_download.png"));
        buttonSave.setActionCommand("Save File");
        buttonSave.setToolTipText("Save File");
        toolbar.add(buttonSave);
        buttonSave.addActionListener(event -> onSaveClick());

      buttonSaveAs = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/saveAsFile_download.png"));
        buttonSaveAs.setActionCommand("Save As");
        buttonSaveAs.setToolTipText("Save As");
        toolbar.add(buttonSaveAs);
        buttonSaveAs.addActionListener(event -> onSaveAsClick());

      toolbar.add(Box.createHorizontalStrut(25));

      // Create the 3 buttons using the icons provided | Naming scheme of buttons is consistant
      // <a href="https://www.flaticon.com/free-icons/user" title="user icons">User icons created by Freepik - Flaticon</a>
      JButton buttonAddCust = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/add_user.png"));
        buttonAddCust.setActionCommand("Insert Customer");
        buttonAddCust.setToolTipText("Insert Customer");
        toolbar.add(buttonAddCust);
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

      // ??
      JButton buttonAddOrder = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P10/gui/resources/add_shopping_cart.png"));
        buttonAddOrder.setActionCommand("Insert Order");
        buttonAddOrder.setToolTipText("Insert Order");
        toolbar.add(buttonAddOrder);
        buttonAddOrder.addActionListener(event -> onInsertOrderClick());

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

      // ??
      JButton buttonViewOrder = new JButton(new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P10/gui/resources/view_shopping-list.png"));
        buttonViewOrder.setActionCommand("View Orders");
        buttonViewOrder.setToolTipText("View Orders");
        toolbar.add(buttonViewOrder);
        buttonViewOrder.addActionListener(event -> onViewClick(Record.ORDER));

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
        setVisible(true);   // Show the main window

      // Start a new store
      onNewClick(DEFAULT_STORE_NAME); // << Prof's code

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

  /* ****************** START NEW LISTNERS PROTECTED ****************** */
  protected void onNewClick() {onNewClick("");} // << Prof's code
  protected void onNewClick(String name) {         // Create a new Store - OK
      String ePrime = " ";
      if(name.isEmpty()) {              // Enhanced to Professor Rice's code below:
          ePrime = (String)JOptionPane.showInputDialog(
          this                          // (1)
          , "Store Name"                // (2)
          , DEFAULT_STORE_NAME          // (3)
          , JOptionPane.PLAIN_MESSAGE   // (4)
          , new ImageIcon("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/new_chipStore.png") // (6)
          , null                        // (6)
          , null);                      // (7)
          if(name.isEmpty()) name = DEFAULT_STORE_NAME;
      }
      store = new Store(ePrime);        // << Instance a new Store | store = new Store("ELSA Prime");
      onViewClick(Record.CUSTOMER);     // << Prof's code
      setDirty(false);                  // << Prof's code
  } // END

  protected void onOpenClick() {      // Create a new game(store) - OK
      final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
      FileFilter storeFiles = new FileNameExtensionFilter("Store files", "ppm"); // Ext. *.ppm (parts per million)
      fc.addChoosableFileFilter(storeFiles);         // Add "Store file" filter
      fc.setFileFilter(storeFiles);                  // Show Store files only by default

      int result = fc.showOpenDialog(this);         // Run dialog, return button clicked
      if (result == JFileChooser.APPROVE_OPTION) {  // Also CANCEL_OPTION and ERROR_OPTION
          filename = fc.getSelectedFile();          // Obtain the selected File object

          try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
              String magicCookie = br.readLine();
              if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Store file");
              String fileVersion = br.readLine();
              if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Store file format");

              store = new Store(br);                // Open a new store
              onViewClick(Record.CUSTOMER);         // << Update the user interface
              setDirty(false);                      // << ^^Prof's code
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e,
                  "Failed", JOptionPane.ERROR_MESSAGE);
           }
      }
  } // END

  protected void onSaveClick() {              // Create a new game
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
          bw.write(MAGIC_COOKIE + '\n');
          bw.write(FILE_VERSION + '\n');
          store.save(bw);
          setDirty(false); // << Added AKS
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
              "Failed", JOptionPane.ERROR_MESSAGE);
      }
  } // END

  protected void onSaveAsClick() {             // Create a new game
      final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
      FileFilter storeFiles = new FileNameExtensionFilter("Store files", "ppm"); // Ext. *.ppm (parts per million)
      fc.addChoosableFileFilter(storeFiles);         // Add "Store file" filter
      fc.setFileFilter(storeFiles);                  // Show Store files only by default

      int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
      if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
          filename = fc.getSelectedFile();         // Obtain the selected File object
          if(!filename.getAbsolutePath().endsWith(".ppm"))  // Ensure it ends with ".ppm"
              filename = new File(filename.getAbsolutePath() + ".ppm"); // Ext. *.ppm (parts per million)
          onSaveClick();                           // Delegate to Save method
      }
  } // END

  /* ****************** END NEW LISTNERS PROTECTED ******************* */

  protected void onAboutClick() { // Display About dialog
      Canvas canvas = new Canvas();

      // add(new Canvas());  // Put the drawing surface in the window
      pack();             // Auto-resize to Canvas.getPreferredSize()

      JLabel logo = null;
      BufferedImage myPicture = null;
      try {
          myPicture = ImageIO.read(new File("/media/sf_vmh_share3RD/2023/Practice/cse1325/P07/gui/resources/network-hub.png"));
          logo = new JLabel(new ImageIcon(myPicture));
      } catch(IOException e) {
      }

      JLabel title = new JLabel("<html>"
        + "<p><font size=+4>" + NAME + "</font></p>"
        + "</html>",
        SwingConstants.CENTER);

      JLabel subtitle = new JLabel("<html>"
        + "<P>Exceptional Laptops and Supercomputers Always</p>"
        + "</html>",
        SwingConstants.CENTER);

      JLabel version = new JLabel("<html>"
        + "<p>Version " + VERSION + "</p>"
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

        + "<br/><p>New Document icon based on work created by Taufik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/files-and-folders title=files-and-folders icons</font></p><br/>"

        + "<br/><p>New ChipStore icon based on work created by by Futuer per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/online-purchase title=online purchase icons</font></p><br/>"

        + "<br/><p>Open File Management icon based on work created by justicon per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/open-folder title=open folder icons</font></p><br/>"

        + "<br/><p>Save File Download icon based on work created by Freepik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/download title=download icons</font></p><br/>"

        + "<br/><p>Save As File Download icon based on work created by Freepik per the Flaticon License</p>"
        + "<p><font size=-2>https://www.flaticon.com/free-icons/installer title=installer icons</font></p><br/>"

        + "</html>");
        // White Telephone | https://www.hotsymbol.com/symbol/white-telephone

        // ImageIcon image = new ImageIcon(myPicture);

        JOptionPane.showOptionDialog(
            this,
            new Object[]{canvas.add(logo), title, subtitle, version, artists},
            "ELSA",
            JOptionPane.OK_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            null, // Object[] options
            null  // Object initialValue
       );
   }

   private void setDirty(boolean isDirty) { // Professor's code below:
       save.setEnabled(isDirty);
       //saveAs.setEnabled(isDirty);
       buttonSave.setEnabled(isDirty);
       //buttonSaveAs.setEnabled(isDirty);
   }; // ^^Prof's code

   // VERY IMPORTANT CHANGE MADE BY PROF - CONSIDER ENHANCEMENTS example UnifiedDialog!!!
   protected void onInsertCustomerClick() { // Revised to Professor's code | NullPointerException
     try {
         String name = JOptionPane.showInputDialog(this, "Customer Name", "New Customer", JOptionPane.PLAIN_MESSAGE);
         String email = JOptionPane.showInputDialog(this, "Customer e-mail", "New Customer", JOptionPane.PLAIN_MESSAGE);
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
     // Load the icon if available
     ImageIcon icon = null;
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
          /* ****************** JComboBox ******************* */
          JLabel compOpt = new JLabel("Computer Options");
          // (A) Obtain an Object[] array of Option objects from store
          // (1) Store.java | public Object[] options() { etc...
          // (B) Instance a JComboBox,
          // (1) Pass the Object[] array retrieved from store as the constructor parameter
          // Object[] options = {store.options()};            // A | 1
          compOpts = new JComboBox<Object>(store.options());  // B | 1
          /* ^^**************** JComboBox *****************^^ */
          int optionsAdded = 0; // Don't add computers with no options
          Object data;
          Object[] objects2 = { // An Array of widget to display
              compOpt, compOpts};
          do {  // Revised to Professor's code
            int button2 = JOptionPane.showConfirmDialog(
                this,                         // Component parentComponent
                objects2,                     // Object message
                "Another Option?",            // [String title
                JOptionPane.YES_NO_OPTION,    // int optionType
                JOptionPane.PLAIN_MESSAGE,    // [int messageType,
                icon);                        // [Icon icon]

            /* User selects an Option via JComboBox */
            /* JComboBox's getSelectedItem() method obtains data */
            data = compOpts.getSelectedItem();

            if(button2 != JOptionPane.YES_OPTION) break;  // If button clicked, NOT EQUAL, then break | responseType: YES_OPTION
            computer.addOption((Option) data);            // Cast converts Object to Option
            ++optionsAdded;                               // button2 equals YES_OPTION; therefore, continue ++count
          } while (true); // end do-while()
          if(optionsAdded > 0) {
            store.add(computer);  // Pass the Computer object built up to store's add method
            onViewClick(Record.COMPUTER); // Invoke call
            setDirty(true);       // Added 4/22/2023 11:39 PM
          } // end if
     } catch(NullPointerException e) {
     } catch(Exception e) {
         JOptionPane.showMessageDialog(this, e,
             "Computer Not Created", JOptionPane.ERROR_MESSAGE);
         System.err.println(e.getMessage());
         // System.exit(-1); | Avoid exiting program
     } // end try-catch
   } // end onInsertComputerClick() |  ^^ Revised to Professor's code ^^

   protected void onInsertOrderClick() {
     // Lecture 13_Custom_dialogs_and_Widgets - Page 18/48
     String name = JOptionPane.showInputDialog(this, "Customer Name", "Inquire Customer", JOptionPane.QUESTION_MESSAGE);
     String email = JOptionPane.showInputDialog(this, "Customer e-mail", "New Customer", JOptionPane.QUESTION_MESSAGE);
     Customer custOrd = new Customer(name, email);
     if (custOrd != null) {
       Order order = new Order(custOrd);
     }
     if(custOrd == null) {
       int n = JOptionPane.showConfirmDialog(
           this,
           "Would you like to create a new customer order? ",
           "Question",
           JOptionPane.YES_NO_OPTION,
           JOptionPane.QUESTION_MESSAGE);

     try {
         checkEmail(email);

     } catch(NullPointerException e) {
     } catch(Exception e) {
     }
     if (n == JOptionPane.YES_OPTION) {
       onInsertCustomerClick();
     } // end if
     if (n == JOptionPane.NO_OPTION) {
       response.setText("No customer created");
     } // end if
   } // end if
   } // end onInsertOrderClick()

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


  private Store store;                  // he current Elsa store
  private JLabel display;               // Main data display

  private File filename;

  private JMenuItem save;
  private JMenuItem saveAs;
  private JButton buttonSave;
  private JButton buttonSaveAs;


  private JLabel response;              // N/A
  private JTextField names;             // Name of parts
  private JTextField costs;             // Cost
  private JComboBox<Object> compOpts;   // JComboBox via Computer Options
  private JTextField models;            // Model

  /*
  private JButton buttonAddCust;        // Button to select 1
  private JButton buttonAddOpt;         // Button to select 2
  private JButton buttonAddComp;        // Button to select 3
  private JButton buttonViewCusts;      // Button to select 4
  private JButton buttonViewOpts;       // Button to select 5
  private JButton buttonViewComps;      // Button to select 6
  */

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
