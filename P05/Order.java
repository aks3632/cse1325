import java.util.ArrayList;

public class Order {

  // Fields
  private static long nextOrderNumber = 0;
  private long orderNumber = nextOrderNumber++;
  private Customer customer;
  private ArrayList<Computer> computers = new ArrayList<>();

  // Constructor
  public Order(Customer customer) {
    this.customer = customer;
  } // end Constructor

  // Methods
  /* addComputer simply adds its parameter to the computers field. */
  public void addComputer(Computer computer) {
    computers.add(computer);
  } // end addComputer

  /* Ex)
  Order 0 for Prof Rice (george.rice@uta.edu)

  SuperCalc (1Z200XL)
     Mainboard ($200.00)
     RAM ($195.00)
     SSD ($55)
     Case ($39) */

  @Override
  public String toString() { // Not accurate
    // Not sure how to iterate via Options (parts) & return
    return "" + "for " + customer.toString() + "\n\n"
           + computers.toString();
           // **Not accurate - derived form computers
           // ^^^^Not sure how to iterate via Options (parts) & return
  } // end toString

  // Method Matcher Object??
  // https://www.tutorialspoint.com/java/java_regular_expressions.htm
  public boolean equals(Object o) {
    return true; // ** Missing Return
  } // end equals

  /*
  if(o == this) return true;               // An object is equal to itself
  if(!(o instanceof Order)) return false;  // A different type is not equal
  Order c = (Order)o;
  return (customer.equals(p.customer)) && (computers.equals(p.computers));
  */

} // end class

/******************************************************************************

* CSE 1320-001 Spring 2023
* File: Customer.java,
* Author:
* Created on: Feb 25, 2023 4:00 AM
.*
* UTA Student Name:
* UTA ID:

*******************************************************************************/

/******************************************************************************
Java Programming Tutorial 62 - Encapsulation (Lecture)
Java Programming Tutorial 63 - Create a Getter
*******************************************************************************/
