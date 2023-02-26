 public class Customer {

   // Fields
   private String name;
   private String email;

   /* Throw a runtime exception if email is invalid.
    * throw new IllegalArgumentException("\nInvalid email. Good bye!"); */
   // Constructor ||| ***Has 3 indexOf methods
   public Customer(String name, String email) {
     this.name = name;
     this.email = email;
   } // end Constructor

   // Method
   @Override
   public String toString() {
     // "Prof Rice (george.rice@uta.edu)"
     // Java Programming Tutorial 15 - String Methods (charAt, concat, contains, indexOf, lastIndexOf)
     return "" + name + " (" + email + ")"; // ** Trial Run |Missing Return
   } // end toString

   // Method Matcher Object??
   // https://www.tutorialspoint.com/java/java_regular_expressions.htm
   public boolean equals(Object o) {
     return true; // ** Missing Return
   } // end equals

 } // end class

 /******************************************************************************

 * CSE 1320-001 Spring 2023
 * File: Customer.java,
 * Author:
 * Created on: Feb 25, 2023 3:40 AM
 .*
 * UTA Student Name:
 * UTA ID:

 *******************************************************************************/

 /******************************************************************************
 Java Programming Tutorial 62 - Encapsulation (Lecture)
 Java Programming Tutorial 63 - Create a Getter
 *******************************************************************************/
