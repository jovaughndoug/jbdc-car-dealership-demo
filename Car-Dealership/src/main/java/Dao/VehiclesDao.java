package Dao;

import java.util.ArrayList;

import com.pluralsight.dealership.Vehicle;

public interface VehiclesDao{
ArrayList<Vehicle> findAllVehicle();
ArrayList<Vehicle> findVehicleByMake( String make);
ArrayList<Vehicle> findVehicleByModel( String model);
ArrayList<Vehicle> findVehicleByColor( String color);
ArrayList<Vehicle> findVehicleByVin( int vin);
ArrayList<Vehicle> findVehicleByType( String model);
ArrayList<Vehicle> findVehicleByPriceRange(double minPrice, double maxPrice);
ArrayList<Vehicle> findVehicleByYear( int year);
ArrayList<Vehicle> findVehicleByMileage(int minMiles, int maxMiles);
void adddVehicle(Vehicle vehicle);
void removeVehicle(int vin);


}
