public abstract class Vehicle {
  // Constructor
  public Vehicle(int year, String make, String model, BodyStyle bodystyle) {
    this.year = year;
    this.make = make;
    this.model = model;
    this.bodystyle = bodystyle;
  } // end Vehicle

  // HINT: Abstract methods cannot have a body.
  public abstract double range();
  public abstract double fuelConsumed(double miles); // *Perhaps honest mistake - Missing parameter double miles
  public abstract double dollarsToTravel(double miles);

  @Override
  public String toString() {
    return " " + year + " " + make + " " + model + " " + bodystyle; //
  }

  // Fields
  private int year;
  private String make;
  private String model;
  private BodyStyle bodystyle;

}
