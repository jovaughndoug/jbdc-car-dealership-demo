package Dao;

import com.pluralsight.dealership.Vehicle;
import jdk.jfr.DataAmount;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleDaoMySqlImpli implements VehiclesDao {
    DataSource dataSource;

    public VehicleDaoMySqlImpli(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Vehicle> findAllVehicle() {
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(" Select * from vehicles");
            ResultSet resultSet = statement.executeQuery();
            while ((resultSet.next())){
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                sold = resultSet.getBoolean("sold");

                Vehicle v = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price,sold);
                allVehicles.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allVehicles;

    }

    @Override
    public ArrayList<Vehicle> findVehicleByMake(String make) {
        ArrayList<Vehicle> vehicleByMake = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                             Select * from vehicles
                             Where make = ?;
                    
                    """);
            statement.setString(1, make);
            ResultSet resultSet = statement.executeQuery();
            while ((resultSet.next())){
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                sold = resultSet.getBoolean("sold");

                Vehicle v = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price, sold);
                vehicleByMake.add(v);
    }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByMake;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByModel(String model) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByColor(String color) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByVin(int vin) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByType(String model) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByPriceRange(String model) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByYear(String model) {
        return null;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByMileage(String model) {
        return null;
    }

    @Override
    public void adddVehicle(Vehicle vehicle) {

    }

    @Override
    public void removeVehicle(int vin) {

    }
}
