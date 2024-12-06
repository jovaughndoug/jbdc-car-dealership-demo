package com.pluralsight.dealership;

public class Vehicle {
    private final Integer vin;
    private final Integer year;
    private final String make;
    private final String model;
    private final String vehicleType;
    private final String color;
    private final Integer odometer;
    private final Double price;

    public String writetocsv() {
        return vin +
                "|" + year +
                "|" + make +
                "|" + model +
                "|" + vehicleType +
                "|" + color +
                "|" + odometer +
                "|" + price+ "\n";
    }

    @Override
    public String toString() {
        return "Vehicle" +
                "vin=" + vin +
                " year=" + year +
                " make='" + make +
                " model='" + model +
                " vehicleType='" + vehicleType +
                " color='" + color +
                " odometer=" + odometer +
                " price=" + price
                ;
    }


    public Integer getVin() {
        return vin;
    }

    public Integer getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public Double getPrice() {
        return price;
    }

    public Vehicle(Integer vin, Integer year, String make, String model, String vehicleType, String color, Integer odometer, Double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
}
