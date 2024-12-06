package Dao;

import com.pluralsight.dealership.Dealership;

import javax.sql.DataSource;
import java.util.List;

public class DealershipDaoMySqlImpli implements DealershipDao {
    DataSource dataSource;

    public DealershipDaoMySqlImpli(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Dealership findDealerShipByID(int id) {

    }

    @Override
    public List<Dealership> findAllDealerships() {
        return null;
    }
}
