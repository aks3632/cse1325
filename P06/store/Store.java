package store;

import java.util.ArrayList;

public class Store {
    public Store(String name) { // Constructor
        this.name = name;
    }
    public String name() {
        return this.name;
    }

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
