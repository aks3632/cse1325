public class ElectricVehicle extends Vehicle {

  // Constructor
  public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile, double kwhInBattery) {
    super(year, make, model, bodystyle);
    this.whPerMile = whPerMile;
    this.kwhInBattery = kwhInBattery;
  } // end ElectricVehicle

  // Methods
  @Override
  public double range() { // Test purposes only set random value
    return kwhInBattery / (whPerMile / 1000);
  };
  @Override
  public double fuelConsumed(double miles) {
    return miles * (whPerMile / 1000);
  };
  @Override
  public double dollarsToTravel(double miles) {
    return fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
  };

  // Fields
  public static double centsPerKwhOfElectricity = Double.NaN;
  private double whPerMile;
  private double kwhInBattery;

}
