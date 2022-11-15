package gui;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

import emporium.Emporium;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;





/* ==========================================================================
*    Title: MainWin
*    Author: George Rice
*    Date: 10/10/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P05
*
========================================================================== */


public class MainWin extends JFrame {// implements ActionListener {

  // Fields
  private Emporium emporium;
  private JLabel display;

  private JButton input; // Hint: Line 10 - OneLiners.java
  private JLabel response;

  // Option Two: add overriding properties to your enums if you want more control
  public enum Modes { // https://stackoverflow.com/questions/6667243/using-enum-values-as-string-literals
    mode1("Ice Cream Flavor"),
    mode2("Mix In Flavor"),
    mode3("Scoop");

    private String label;

    private Modes(String mode) {
        this.label = mode;
    }
    public String getLabel() {
       return label;
    }
  };


    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        /*
        //Get all enums
        for(Modes imsSel : Modes.values())
        {
            System.out.println(imsSel.name() + " :: " + imsSel.getLabel());
        }
        */

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();

        JMenu     file        = new JMenu("File");
        JMenuItem open        = new JMenuItem("Open");    // Professors code
                  save        = new JMenuItem("Save");    // Professors code
                  saveAs      = new JMenuItem("Save As"); // Professors code
        JMenuItem quit        = new JMenuItem("Quit");
        JMenu     view        = new JMenu ("View");
        JMenuItem viewICF     = new JMenuItem(Modes.mode1.getLabel());
        JMenuItem viewMIF     = new JMenuItem(Modes.mode2.getLabel());
        JMenuItem viewScoop   = new JMenuItem(Modes.mode3.getLabel());
        JMenu     create      = new JMenu("Create");
        JMenuItem createICF   = new JMenuItem(Modes.mode1.getLabel());
        JMenuItem createMIF   = new JMenuItem(Modes.mode2.getLabel());
        JMenuItem createScoop = new JMenuItem(Modes.mode3.getLabel());
        JMenu     help        = new JMenu("Help");
        JMenuItem about       = new JMenuItem("About");

        open      .addActionListener(event -> onOpenClick());
        save      .addActionListener(event -> onSaveClick());
        saveAs    .addActionListener(event -> onSaveAsClick());
        quit      .addActionListener(event -> onQuitClick());
        about     .addActionListener(event -> onAboutClick());
        createICF .addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF .addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());

        file.add(open);   // Professors code
        file.add(save);   // Professors code
        file.add(saveAs); // Professors code
        file.add(quit);
        view.add(Modes.mode1.getLabel());
        view.add(Modes.mode2.getLabel());
        view.add(Modes.mode3.getLabel());
        create.add(createICF);
        create.add(createMIF);
        create.add(createScoop);
        help.add(about);

        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);

        setJMenuBar(menubar);

        // /////////////////////////// ////////////////////////////////////////////
         // M A I N   D I S P L A Y
         // Provide a text entry box to show data
         display = new JLabel();
         display.setFont(new Font("Courier New", Font.BOLD, 18));
         display.setVerticalAlignment(JLabel.TOP);
         add(display, BorderLayout.CENTER);


        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("MICE Controls");

        // Add a New Emporium icon - Professors code
         saveButton  = new JButton(new ImageIcon("gui/save.png"));
           saveButton.setActionCommand("Save data to default file");
           saveButton.setToolTipText("Save data to default file");
           saveButton.setEnabled(false);
           saveButton.addActionListener(event -> onSaveClick());
           toolbar.add(saveButton);

         saveAsButton  = new JButton(new ImageIcon("gui/save_as.png"));
           saveAsButton.setActionCommand("Save data to selected file");
           saveAsButton.setToolTipText("Save data to selected file");
           saveAsButton.addActionListener(event -> onSaveAsClick());
           toolbar.add(saveAsButton);

         JButton openButton  = new JButton(new ImageIcon("gui/open.png"));
           openButton.setActionCommand("Load data from selected file");
           openButton.setToolTipText("Load data from selected file");
           openButton.addActionListener(event -> onOpenClick());
           toolbar.add(openButton); // Professors code

        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
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

        getContentPane().add(toolbar, BorderLayout.PAGE_START); // END OF TOOLBAR BUTTONS

        // Make everything in the JFrame visible
        setVisible(true);

        // Start a new emporium
        emporium = new Emporium();


    } // end MainWin


    // Listners

    // ///////////////////////////////////////////////
    // Input Dialog

    // Listeners
    public void onQuitClick() {System.exit(0);}   // Exit the game

    protected void onCreateIceCreamFlavorClick() { // Professors code
      try {
          emporium.addIceCreamFlavor(new IceCreamFlavor(
              JOptionPane.showInputDialog(this, "Name?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
              JOptionPane.showInputDialog(this, "Description?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
              Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
              Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
          ));
      } catch(Exception e) {
      }
      try {
          // setScoopAvailable();
          // setDirty(true);
          // view(Screen.ICE_CREAM_FLAVORS);
      } catch(Exception e) {
          System.err.println("onCreateIceCreamFlavorClick exception: " + e);
      }
  } // end ocicfc Professors cod

  // File I/O Methods
/* Boarder plate code is NOT on EXAM2 - extra Prof. always copies & paste lines 273 - 283 */
 protected void onOpenClick() { // READS OR LOADS DATA!!
      final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
      FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
      fc.addChoosableFileFilter(miceFiles);         // Add "Mice file" filter
      fc.setFileFilter(miceFiles);                  // Show Mice files only by default

      int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
      if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
          filename = fc.getSelectedFile();        // Obtain the selected File object

          try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
              String magicCookie = br.readLine();
              if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a MICE file");
              String fileVersion = br.readLine();
              if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible MICE file format");

              emporium = new Emporium(br);                   // Open a new emporium
              // view(Screen.SCOOPS);                           // Update the user interface
              setScoopAvailable();
              setDirty(false);
          } catch (Exception e) {
              JOptionPane.showMessageDialog(this,"Unable to load " + filename + '\n' + e,
                  "Failed", JOptionPane.ERROR_MESSAGE);
           }
      }
  }

  protected void onSaveClick() { // OK - Professors code mentioned in Lecture - WRITES DATA
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
          bw.write(MAGIC_COOKIE + '\n'); // NOT required to do MAGIC_COOKIE per Prof!
          bw.write(FILE_VERSION + '\n');
          emporium.save(bw);
          setDirty(false);
      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Unable to write " + filename + '\n' + e,
              "Failed", JOptionPane.ERROR_MESSAGE);
      }
  }
/* Boarder plate code is NOT on EXAM2 - extra Prof. always copies & paste lines 312 - 320 */
  protected void onSaveAsClick() { // ***** Prof's lecture *****
      final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
      FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
      fc.addChoosableFileFilter(miceFiles);         // Add "MICE file" filter
      fc.setFileFilter(miceFiles);                  // Show MICE files only by default

      int result = fc.showSaveDialog(this);         // Run dialog, return button clicked
      if (result == JFileChooser.APPROVE_OPTION) {  // Also CANCEL_OPTION and ERROR_OPTION
          filename = fc.getSelectedFile();          // Obtain the selected File object
          if(!filename.getAbsolutePath().endsWith("." + EXTENSION))  // Ensure it ends with ".mice"
              filename = new File(filename.getAbsolutePath() + "." + EXTENSION);
          onSaveClick();                           // Delegate to Save method
      }
  }

  // About and miscellaneous

    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporium");

        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }

        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>MICE</font></p>" // Replaced Nim with MICE
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.3J</p>"
          + "<p>Copyright 2017-2020 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JPanel panel = new JPanel(); // Prof
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        about.add(panel);

        about.setSize(450,400);
        about.pack();
        about.setVisible(true);
     }

     private void setDirty(boolean isDirty) {
         save.setEnabled(isDirty);
         saveAs.setEnabled(isDirty);
         saveButton.setEnabled(isDirty);
         saveAsButton.setEnabled(isDirty);
     };

     private Emporium emporium;
     private File filename;

     private JLabel display;                 // Main data display

     private JMenuItem save;
     private JMenuItem saveAs;
     private JButton saveButton;
     private JButton saveAsButton;

     private JMenuItem createScoop;  // defined here so we can disable and enable it
     // private JButton createScoopButton;


} // end class MainWin
