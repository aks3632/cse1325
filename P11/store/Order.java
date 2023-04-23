package store;

import java.util.ArrayList;
import java.io.IOException;     // reports an error reading from a file
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Order {

  // Fields
  protected long cost;
  private static long nextOrderNumber = 0;
  private long orderNumber;   // ** Updated to Profs code 3/1/23
  private Customer customer;  // A class we wrote
  private ArrayList<Computer> computers = new ArrayList<>();

  // Constructor
  public Order(Customer customer) {
    this.customer = customer;
    this.orderNumber = nextOrderNumber++; // ** Updated to Profs code 3/1/23
  } // end Constructor

  /* Save method writes the object's fields to a file */
  public void save(BufferedWriter bw) throws IOException {
    bw.write("" + nextOrderNumber + '\n');
    bw.write("" + orderNumber + '\n');
    customer.save(bw);                      // Instance own Class
    bw.write("" + computers.size() + '\n'); // A) Write the # of elements |& determine Size of ArrayList
    for(Computer computer : computers) {    // B) Write each element in ArrayList via for-each loop
      computer.save(bw);
    } // end for-each
  } // end save

  /* Constructor recreates an object from a file */
  public Order(BufferedReader br) throws IOException {
    this.nextOrderNumber = Long.parseLong(br.readLine());
    this.orderNumber = Long.parseLong(br.readLine());
    customer = new Customer(br);                // Instance own Class
    int size = Integer.parseInt(br.readLine()); // Size of ArrayList
    while(size-- > 0 ) computers.add(new Computer(br)); // Recreate and add each element in ArrayList via while loop
  } // end Constructor

  // Methods
  /* addComputer simply adds its parameter to the computers field. */
  public void addComputer(Computer computer) {
    computers.add(computer);
  } // end addComputer

  // Method -- NEW 2/18/23
  /* Returns the sum of the cost of each Option in the options ArrayList */
  public long cost() {
    long sum = 0;
    long totalCost = 0;

    for(Computer smpCost : computers) {
      sum += smpCost.cost();
    } // end for:each loop
    return totalCost = sum;
  } // end cost


  /* Ex) - Enhanced!
  Order 0 for Prof Rice (george.rice@uta.edu)

  SuperCalc (1Z200XL)
     Mainboard ($200.00)
     RAM ($195.00)
     SSD ($55)
     Case ($39) */

  @Override
  public String toString() { // Professor Rice's code below:
    int dollars = (int)cost / 100;
    int cents = (int)cost % 100;

    // Resolved | Obtains iteration of Options (parts) via Computer class!
    StringBuilder sb = new StringBuilder("Order " + orderNumber + " for " + customer + " "
        + "($" + dollars + "." + ((cents < 10) ? "0" : "") + cents +")");
    for(Computer c : computers) sb.append("\n\n" + c); // ** Derived form computers
    return sb.toString();
  } // end toString

  @Override
  public boolean equals(Object o) {

    try {
        if(o == this) return true;              // (1) An object is equal to itself
        if(!(o instanceof Order)) return false; // (2) A different type is not equal
        Order c = (Order)o;                     // (3) Cast
        // Professor Rice's code below:
        if(!this.customer.equals(c.customer)) return false;
        if(this.computers.size() != c.computers.size()) return false;
        for(int i=0; i<this.computers.size(); ++i)
            if(!this.computers.get(i).equals(c.computers.get(i))) return false;  // (4) Compare three name & model & options.toString() |?
        return true;
    } catch(Exception e) {
        return false;
    } // end try-catch
  } // end equals
  /* Old Programmer's Trick mentioned for Computer.equals won't work for Order */
  /* https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object) */
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
GOOD
Lines ** | equals(Object o) vs Lines 25 - 36 (Prof's very COMPLEX!!!)
Lines ** | @Override public String toString() | Updated to Prof's code
*******************************************************************************/
