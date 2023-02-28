import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

 public class Customer {

   // Fields
   private String name;
   private String email;
   /* https://www.geeksforgeeks.org/check-email-address-valid-not-java/ */
   /* ^^^^ Referenced above
   GOOD - Partitioned
   "^[a-zA-Z0-9_+&*-]+(?:\\."+
   "[a-zA-Z0-9_+&*-]+)*@" +
   "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
   "A-Z]{2,7}$";
   ^^^^ Referenced above
   GOOD - Identical continuous sequence
   "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
   */

   /* Professor's code - PATTERN REGEX E-MAIL | ~ "Not working" */
   /* ^([a-zA-Z0-9_-.]+)@([a-zA-Z0-9_-.]+).([a-zA-Z]{2,5})$ */
   // Utilized geeksforgeeks GOOD REGEX pattern for convenience
   public static final String PTTNREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

   /* Throw a runtime exception if email is invalid. */
   // Constructor ||| ***(1st Option): Has 3 indexOf methods OR (2nd Option): Seek REGEX
   public Customer(String name, String email) {
     if(isVAV(email) == false) { // **2nd x| (Twice): Validate or check data NOT invalid e-mail
       throw new IllegalArgumentException("\nInvalid email. Good bye!");
     } // end if
     this.name = name;
     this.email = email;
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

     try { /* Perform data validation on email */
       isVAV(email); // Returns a boolean

     } catch(Exception e) {
       System.err.println("Ending program: " + e.getMessage());
       System.exit(-1);
     } // end try-catch

     // "Prof Rice (george.rice@uta.edu)"
     // Java Programming Tutorial 15 - String Methods (charAt, concat, contains, indexOf, lastIndexOf)
     return "" + name + " (" + email + ")"; // ** Trial Run |Missing Return
   } // end toString

   /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */
   /* complex04 - complex07 | ~/cse1325-prof/04/code_from_slides/complex04 */
   @Override
   public boolean equals(Object o) {
     if(o == this) return true;                     // (1) An object is equal to itself
     /* Aggregation to Order? (Customer)--<>(Order | Open diamond) */
     if(!(o instanceof Customer)) return false;     // (2) A different type is not equal
     Customer c = (Customer)o;                      // (3) Cast
     return (name.equals(c.name)) && (email.equals(c.email)); // (4) Compare two name & email |? (name == c.name) && (email == c.email);
     // Used String Method "equals", becasue name & email are [Strings]
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
 Java Programming Tutorial 16 - More String Methods (toLowerCase, strip, substring, repeat, equals)
 *******************************************************************************/
