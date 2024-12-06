package Dao;

import com.pluralsight.dealership.Dealership;

import java.util.List;

public interface DealershipDao {
    Dealership findDealerShipByID(int id);
    List<Dealership>findAllDealerships();

}
