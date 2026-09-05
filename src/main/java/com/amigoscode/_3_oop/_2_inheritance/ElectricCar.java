package com.amigoscode._3_oop._2_inheritance;

/**
 * Exercise: Inheritance - ElectricCar Subclass
 *
 * Create an ElectricCar that extends Vehicle. Practice constructor
 * chaining with super(), overriding methods, and adding behavior
 * unique to electric vehicles.
 *
 * Key concepts:
 * - Extending a parent class and calling super()
 * - Overriding methods to change behavior
 * - Adding subclass-specific fields and methods
 */

public class ElectricCar extends Vehicle {

    private int batteryLevel;

    public ElectricCar(String make, String model, int year, int batteryLevel) {
        super(make, model, year);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void start() {
        System.out.printf("%s %s electric motor starting silently...%n", this.make, this.model);
    }

    public void charge(int percent){
        this.batteryLevel = Math.min(this.batteryLevel + percent, 100);
        System.out.printf("Charging... Battery now at %s%%",this.batteryLevel);
        System.out.println();
    }

    public String getBatteryStatus(){
        return "Battery: %d%%".formatted(batteryLevel);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", batteryLevel=" + batteryLevel +
                '}';
    }

    public static void main(String[] args) {
        // Uncomment and test after completing the TODOs:
         ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 85);
         System.out.println(tesla);
         tesla.start();                      // overridden — silent start
         System.out.println(tesla.getInfo()); // inherited from Vehicle
         System.out.println(tesla.getBatteryStatus());

         tesla.charge(20);
         System.out.println(tesla.getBatteryStatus());

         // Polymorphism: an ElectricCar IS-A Vehicle
         Vehicle vehicle = new ElectricCar("Rivian", "R1T", 2025, 60);
         vehicle.start(); // calls ElectricCar's overridden version
    }
}
