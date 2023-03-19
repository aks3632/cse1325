package store;

import java.util.ArrayList;
import java.io.IOException;     // reports an error reading from a file
import java.io.BufferedWriter;
import java.io.BufferedReader;

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
      bw.write(customers.size() + '\n');    // A) 1st write # of elements here
      for(Customer customer : customers) {  // B) Write each element in ArrayList via for-each loop
        customer.save(bw);
      } // end for-each

      bw.write(options.size() + '\n');      // A) 1st write # of elements here
      for(Option option : options) {        // B) Write each element in ArrayList via for-each loop
        option.save(bw);
      } // end for-each

      bw.write(computers.size() + '\n');    // A) 1st write # of elements here
      for(Computer computer : computers) {  // B) Write each element in ArrayList via for-each loop
        computer.save(bw);
      } // end for-each

      bw.write(orders.size() + '\n');        // A) 1st write # of elements here
      for(Order order : orders) {            // B) Write each element in ArrayList via for-each loop
        order.save(bw);
      } // end for-each
    } // end save

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
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Option> options = new ArrayList<>();
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
}
