package store;

import java.util.ArrayList;
import java.io.IOException;     // reports an error reading from a file
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Store {
    public Store(String name) { // Constructor
        this.name = name;
    }
    public String name() {
        return this.name;
    }

    // ///////////////////////////////////////////////////////////
    // Save (via method) & reload (via constructor) each object

    /* Save method writes the objec's fields to a file */
    public void save(BufferedWriter bw) throws IOException {

      bw.write(name + '\n');

      bw.write("" + customers.size() + '\n');   // A) 1st write # of elements here
      for(Customer customer : customers) {      // B) Write each element in ArrayList via for-each loop
        customer.save(bw);
      } // end for-each

      bw.write("" + options.size() + '\n');     // A) 1st write # of elements here
      for(Option option : options) {            // B) Write each element in ArrayList via for-each loop
        option.save(bw);
      } // end for-each

      bw.write("" + computers.size() + '\n');   // A) 1st write # of elements here
      for(Computer computer : computers) {      // B) Write each element in ArrayList via for-each loop
        computer.save(bw);
      } // end for-each

      bw.write("" + orders.size() + '\n');      // A) 1st write # of elements here
      for(Order order : orders) {               // B) Write each element in ArrayList via for-each loop
        order.save(bw);
      } // end for-each
    } // end save

    /* Constructor recreates an object from a file */
    public Store(BufferedReader br) throws IOException {

      this.name = br.readLine();

      int size = Integer.parseInt(br.readLine()); // A) 1st read # of elements here
      while(size-- > 0) {                         // B) Read & add each element in ArrayList via while loop
        customers.add(new Customer(br));
      } // end while

      size = Integer.parseInt(br.readLine());     // A) 1st read # of elements here
      while(size-- > 0) {                         // B) Read & add each element in ArrayList via while loop
        options.add(new Option(br));
      } // end while

      size = Integer.parseInt(br.readLine());     // A) 1st read # of elements here
      while(size-- > 0) {                         // B) Read & add each element in ArrayList via while loop
        computers.add(new Computer(br));
      } // end while

      size = Integer.parseInt(br.readLine());     // A) 1st read # of elements here
      while(size-- > 0) {                         // B) Read & add each element in ArrayList via while loop
        orders.add(new Order(br));
      } // end while
    } // end Constructor

    // ///////////////////////////////////////////////////////////
    // Customers

    public void add(Customer customer) {
        if(!customers.contains(customer)) customers.add(customer);
    }
    public Object[] customers() {
        return this.customers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Options

    public void add(Option option) {
        if(!options.contains(option)) options.add(option);
    }
    public Object[] options() { // Getter
        return this.options.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Computers

    public void add(Computer computer) {
        if(!computers.contains(computer)) computers.add(computer);
    }
    public Object[] computers() { // Getter
        return this.computers.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Orders

    public void add(Order order) {
        if(!orders.contains(order)) orders.add(order);
    }
    public Object[] orders() {  // Getter
        return this.orders.toArray();
    }

    // ///////////////////////////////////////////////////////////
    // Fields

    private String name;
    private TreeSet<Customer> customers = new TreeSet<>();
    private HashSet<Option> options = new HashSet<>();
    private HashSet<Computer> computers = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();
    /*
    HashSet for Option, Computer, and Order objects in
    Store will ensure we have no duplicates.
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    https://www.geeksforgeeks.org/how-to-convert-arraylist-to-hashset-in-java/
    */
}
