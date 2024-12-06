package com.pluralsight.dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;

    private final ArrayList<Vehicle> inventory;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }




    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesPriceRange = inventory.stream().filter(
                vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max).toList();
        return vehiclesPriceRange;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        List<Vehicle> vehiclesWithMakeModel = inventory.stream().filter(
                vehicle -> vehicle.getMake().equalsIgnoreCase(make)
                        && vehicle.getModel().equalsIgnoreCase(model)).toList();
        return vehiclesWithMakeModel;

    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesWithYear = inventory.stream().filter(
                vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max).toList();
        return vehiclesWithYear;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesByColor = inventory.stream().filter(
                vehicle -> vehicle.getColor().equalsIgnoreCase(color)).toList();
        return vehiclesByColor;

    }

    public List<Vehicle> getVehiclesByMiles(int min, int max) {
        List<Vehicle> vehicleByMiles = inventory.stream().filter(
                vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max).toList();
        return vehicleByMiles;
    }

    public List<Vehicle> getByVehicleType(String type) {
        List<Vehicle> vehiclewithType = inventory.stream().filter(
                vehicle -> vehicle.getVehicleType().equalsIgnoreCase(type)).toList();
        return vehiclewithType;
    }
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }


}
