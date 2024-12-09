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
    DataSource  dataSource;

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

                Vehicle v = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price, sold);
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
        ArrayList<Vehicle> vehicleByModel = new ArrayList<>();
        int vin;
        int year;
        String make;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                             Select * from vehicles
                             Where model = ?;
                             """);
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
                vehicleByModel.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByModel;

    }



    @Override
    public ArrayList<Vehicle> findVehicleByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        int odometer;
        double price;
        boolean sold;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    Select * FROM vehicles
                    Where color = ?;
                    """);
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
                vehiclesByColor.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByColor;

    }

    @Override
    public ArrayList<Vehicle> findVehicleByVin(int vin) {
        ArrayList<Vehicle> vehiclesByVIN = new ArrayList<>();
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
                    Select * From vehicles
                    Where vin = ?;
                    """);
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
                vehiclesByVIN.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByVIN;

    }

    @Override
    public ArrayList<Vehicle> findVehicleByType(String vehicleType) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String color;
        int odometer;
        double price;
        boolean sold;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    Select * From vehicles
                    Where type = ?;
                    """);
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
                vehiclesByType.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByType;

    }

    @Override
    public ArrayList<Vehicle> findVehicleByPriceRange(double minPrice, double maxPrice) {
            ArrayList<Vehicle> vehicleByPrice = new ArrayList<>();
            int vin;
            int year;
            String make;
            String model;
            String vehicleType;
            String color;
            int odometer;
            double price;
            boolean sold;

            try (Connection connection = dataSource.getConnection()){
                PreparedStatement statement = connection.prepareStatement("""
                    Select * FROM vehicles 
                    Where price BETWEEN ? AND ?;
                    """);

                statement.setDouble(1, minPrice);
                statement.setDouble(2, maxPrice);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()){
                    vin = resultSet.getInt("vin");
                    year = resultSet.getInt("year");
                    make = resultSet.getString("make");
                    model = resultSet.getString("model");
                    vehicleType = resultSet.getString("type");
                    color = resultSet.getString("color");
                    odometer = resultSet.getInt("odometer");
                    price = resultSet.getDouble("price");
                    sold = resultSet.getBoolean("sold");

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                    vehicleByPrice.add(v);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return vehicleByPrice;
        }




    @Override
    public ArrayList<Vehicle> findVehicleByYear(int year) {
        ArrayList<Vehicle> vehicleByYear = new ArrayList<>();
        int vin;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE year = ?;
                    """);

            statement.setInt(1, year);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                sold = resultSet.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehicleByYear.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleByYear;
    }

    @Override
    public ArrayList<Vehicle> findVehicleByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> vehiclesByOdometer = new ArrayList<>();
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;
        boolean sold;

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;
                    """);

            statement.setDouble(1, minMileage);
            statement.setDouble(2, maxMileage);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                vin = resultSet.getInt("vin");
                year = resultSet.getInt("year");
                make = resultSet.getString("make");
                model = resultSet.getString("model");
                vehicleType = resultSet.getString("type");
                color = resultSet.getString("color");
                odometer = resultSet.getInt("odometer");
                price = resultSet.getDouble("price");
                sold = resultSet.getBoolean("sold");

                Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold);
                vehiclesByOdometer.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehiclesByOdometer;

    }

    @Override
    public void adddVehicle(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection()) {
            int vin = 0;
            int year = 0;
            String make = "";
            String model = "";
            String vehicleType = "";
            String color = "";
            int odometer = 0;
            double price = 0.0;
            boolean sold = false;

            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO vehicles
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                    """);

            statement.setInt(1, vin);
            statement.setInt(2, year);
            statement.setString(3, make);
            statement.setString(4, model);
            statement.setString(5, vehicleType);
            statement.setString(6, color);
            statement.setInt(7, odometer);
            statement.setDouble(8, price);
            statement.setBoolean(9, sold);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + "rows inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void removeVehicle(int vin) {
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    Delete FROM vehicles 
                    Where vin = ?;
                    """);

            statement.setInt(1, vin);

            int alteredRows = statement.executeUpdate();
            System.out.println(alteredRows + "rows affected");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

     }
