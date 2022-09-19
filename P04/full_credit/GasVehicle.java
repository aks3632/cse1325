public class GasVehicle extends Vehicle {

  // Constructor
  public GasVehicle(int year, String make, String model, BodyStyle bodystyle, double milesPerGallon, double gallonsInTank) {
    super(year, make, model, bodystyle); // call to super must be first statement in constructor
    this.milesPerGallon = milesPerGallon;
    this.gallonsInTank = gallonsInTank;
  } // end GasVehicle

  // Methods
  public double range() { // Test purposes only set random value
    return 1.0;

  };
  public double fuelConsumed(double miles) {
    return 2.0;

  };
  public double dollarsToTravel(double miles) {
    return 3.0;
  };

  // Fields
  public static double dollarsPerGallonOfGas;
  private double milesPerGallon;
  private double gallonsInTank;

}
