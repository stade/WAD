package wad.myytavatasunnot.database;


import java.util.List;
import wad.myytavatasunnot.domain.House;





public interface HouseDao extends DAO<House> {

    public List<House> listHouses();
    
   
    
    
}
