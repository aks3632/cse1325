public class ElectricVehicle extends Vehicle {

  // Constructor
  public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile, double kwhInBattery) {
    super(year, make, model, bodystyle);
    this.whPerMile = whPerMile;
    this.kwhInBattery = kwhInBattery;
  } // end ElectricVehicle

  // Methods
  public double range() { // Test purposes only set random value
    return 1.1;
  };
  public double fuelConsumed(double miles) {
    return 2.2;
  };
  public double dollarsToTravel(double miles) {
    return 3.3;
  };

  // Fields
  public static double centsPerKwhOfElectricity;
  private double whPerMile;
  private double kwhInBattery;

}
