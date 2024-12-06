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
ArrayList<Vehicle> findVehicleByPriceRange( String model);
ArrayList<Vehicle> findVehicleByYear( String model);
ArrayList<Vehicle> findVehicleByMileage( String model);
void adddVehicle(Vehicle vehicle);
void removeVehicle(int vin);


}
