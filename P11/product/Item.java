package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Item { // Superclass

  // Constructor
  public Item(String name, String description, int cost, int price) {
    this.name = name;
    this.description = description;
    this.cost = cost;
    this.price = price;
  } // Constructor

  // Professor's code
  public Item(BufferedReader br) throws IOException { // Reading data back in
      this.name = br.readLine();
      this.description = br.readLine();
      this.cost = Integer.parseInt(br.readLine());
      this.price = Integer.parseInt(br.readLine());
  } // Constructor

  // Professor's code
  public void save(BufferedWriter bw) throws IOException { // Writing data out to be saved!
      bw.write(name + '\n');
      bw.write(description + '\n');
      bw.write("" + cost + '\n');
      bw.write("" + price + '\n');
  }

  // Methods - Similar to functions that do something
  public String name() {return name;}
  public String description() {return description;}
  public int price() {return price;}
  public int cost() {return cost;}

  @Override
  public String toString() {
    return "" + name + " " + description + " " + cost + " " + price;
  }

  // Fields
  private String name; // 4 pices of data to be saved!
  private String description;
  private int cost;
  private int price;
}
