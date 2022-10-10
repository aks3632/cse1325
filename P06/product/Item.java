package product;

public class Item { // Superclass

  // Constructor
  public Item(String name, String description, int cost, int price) {
    this.name = name;
    this.description = description;
    this.cost = cost;
    this.price = price;
  } // end Constructor

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
  private String name;
  private String description;
  private int cost;
  private int price;

}
