package store;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.util.*;
import java.io.IOException;     // reports an error reading from a file
import java.io.BufferedReader;
import java.io.BufferedWriter;

 public class Customer {

   // Fields
   private String name;
   private String email;
   /* ********************************************************************************* */
   /* Professor's code - PATTERN REGEX E-MAIL | ~ "Not working" */
   /* BAD - "^([a-zA-Z0-9_-.]+)@([a-zA-Z0-9_-.]+).([a-zA-Z]{2,5})$" | Continuous sequence */
   /* ********************************************************************************* */
   /* Referenced & Utilized geeksforgeeks GOOD REGEX pattern for convenience */
   /* https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
   /* GOOD - "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; | Continuous sequence */
   /* ********************************************************************************* */
   public static final String PTTNREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

   /* Throw a runtime exception if email is invalid. */
   // Constructor ||| ***(1st Option): Has 3 indexOf methods OR (2nd Option): Seek REGEX
   public Customer(String name, String email) {
     if(isVAV(email) == false) { // **2nd x| (Twice): Validate or check data NOT invalid e-mail
       throw new IllegalArgumentException("\nInvalid email: " + email + " Good Bye!!"); // Updated to Profs codes
     } // end if
     this.name = name;
     this.email = email;
   } // end Constructor

   /* Save method writes the objec's fields to a file */
   public void save(BufferedWriter bw) throws IOException { // Save Method
     bw.write(name  + '\n');       // write to String
     bw.write(email + '\n');
     // bw.write(PTTNREGEX + '\n');
   } // end save

   /* Constructor recreates the object from a file */
   public Customer(BufferedReader br) throws IOException { // Constructor
     this.name = br.readLine();
     this.email = br.readLine();
   } // end Constructor

   /* ************************************* REGEX ************************************* */

  /* https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
  /* https://www.tutorialspoint.com/java/java_regular_expressions.htm */
  public static boolean isVAV(String email) {

    Pattern pattnSeq = Pattern.compile(PTTNREGEX, Pattern.CASE_INSENSITIVE); // TestPt extra parameter
    if(email == null) { // **1st | (Once): Validate or check data NOT invalid e-mail
      return false;
    } // end if
    return pattnSeq.matcher(email).matches();
  } // end isVAV

  /* ************************************* REGEX ************************************* */

   // Method
   @Override
   public String toString() {
     // Per TA - “try-catch” - NOT required
     // "Prof Rice (george.rice@uta.edu)"
     return "" + name + " (" + email + ")"; // ** Trial Run |Missing Return
   } // end toString

   /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */
   /* complex04 - complex07 | ~/cse1325-prof/04/code_from_slides/complex04 */
   @Override
   public boolean equals(Object o) {

     try {
         if(o == this) return true;                     // (1) An object is equal to itself
         /* Aggregation to Order? (Customer)--<>(Order | Open diamond) */
         if(!(o instanceof Customer)) return false;     // (2) A different type is not equal
         Customer c = (Customer)o;                      // (3) Cast
         return (name.equals(c.name)) && (email.equals(c.email)); // (4) Compare two name & email |? (name == c.name) && (email == c.email);
         // Used String Method "equals", becasue name & email are [Strings]
     } catch(Exception e) {
         return false;
     } // end try-catch
   } // end equals
 } // end class

 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Customer.java,
 * Author:
 * Created on: Feb 26, 2023 6:22 PM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /******************************************************************************
 GOOD!
 Added try-catch to equals(Object o) + this
 Java Programming Tutorial 15 - String Methods (charAt, concat, contains, indexOf, lastIndexOf)
 Java Programming Tutorial 16 - More String Methods (toLowerCase, strip, substring, repeat, equals)
 *******************************************************************************/
