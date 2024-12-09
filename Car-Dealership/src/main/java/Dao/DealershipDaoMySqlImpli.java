package Dao;

import com.pluralsight.dealership.Dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipDaoMySqlImpli implements DealershipDao {
    DataSource dataSource;

    public DealershipDaoMySqlImpli(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Dealership findDealerShipByID(int id) {
        String businessName = "";
        String phone = "";
        String address = "";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("""
                    Select *
                    From dealerships
                    Where id = ?;
                   
                    """);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                id = resultSet.getInt(id);
                businessName = resultSet.getString("name");
                address = resultSet.getString("address");
                phone = resultSet.getString("phone");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Dealership(businessName,address,phone);


    }

    @Override
    public List<Dealership> findAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String name;
        String address;
        String phone;
        int id;

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement allDealerships = connection.prepareStatement("""
                    Select *
                    From dealerships;
                    
                    """);
            allDealerships.executeQuery();
            ResultSet resultSet = allDealerships.getResultSet();

            while(resultSet.next()){
                id = resultSet.getInt("dealership_id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                phone = resultSet.getString("phone");

            }
            return dealerships;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
