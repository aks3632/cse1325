import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TravelCost {
  public static void main(String[] args) { // function main begins program execution

    Scanner scannerVin = new Scanner(System.in);

    System.out.println("What is the price per gallon of gas (dollars)? "); // Prompt user $ of gasolnie
    GasVehicle.dollarsPerGallonOfGas = scannerVin.nextDouble(); // Get value: US currency $

    System.out.println("What is the price per kWh of electricity (cents)? "); // Prompt user $ of electricity
    ElectricVehicle.centsPerKwhOfElectricity = scannerVin.nextDouble(); // Get value: US cents $

    System.out.println("How many miles is your trip? ");
    double mi = scannerVin.nextDouble(); // Get value: Miles - length or distance
                                                                                            // wh/mi kwBat
    ArrayList<Vehicle> vehicles = new ArrayList<>();                                         // mi/gal galTank
    vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model S Plaid",   BodyStyle.Sedan,     297, 100  ));
    vehicles.add(new ElectricVehicle(2022, "Telsa",    "Model 3 LR",      BodyStyle.Sedan,     242,  82  ));
    vehicles.add(new ElectricVehicle(2022, "GM",       "Bolt",            BodyStyle.Hatchback, 286,  66  ));
    vehicles.add(new ElectricVehicle(2022, "Nissan",   "LEAF",            BodyStyle.Hatchback, 269,  60  ));
    vehicles.add(new ElectricVehicle(2022, "Ford",     "Mustang Mach-E",  BodyStyle.SUV,       347,  88  ));
    vehicles.add(new ElectricVehicle(2022, "Ford",     "F-150 Lightning", BodyStyle.Truck,     511, 131  ));
    vehicles.add(new GasVehicle(     2022, "Ford",     "F-150",           BodyStyle.Truck,      25,  23  ));
    vehicles.add(new GasVehicle(     2022, "Toyota",   "Prius Hybrid",    BodyStyle.Hatchback,  55,  11.4));
    vehicles.add(new GasVehicle(     2022, "Toyota",   "RAV4",            BodyStyle.Crossover,  31,  14.5));
    vehicles.add(new GasVehicle(     2022, "Nissan",   "Rogue",           BodyStyle.Hatchback,  33,  14.5));
    vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica",        BodyStyle.Minivan,    24,  19  ));
    vehicles.add(new GasVehicle(     2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan,    30,  16.5));

    /*
    // Or use the for-each loop on either
    for(int i : array) System.out.printf(" %2d", i);
    System.out.println();
    for(int i : ali)   System.out.printf(" %2d", i);
    System.out.println();
    */

  } // end main()
} // end TravelCost
