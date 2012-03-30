package wad.myytavatasunnot.service;


import org.springframework.stereotype.Service;
import wad.myytavatasunnot.domain.House;
import wad.myytavatasunnot.domain.HouseForm;
import wad.myytavatasunnot.domain.Seller;


@Service
public class SimpleFormService implements FormService {



    @Override
    public House createHouse(HouseForm houseform) {
        House house = new House();
        house.setAddress(houseform.getHouseAddress());
        house.setBuildyear(Integer.parseInt(houseform.getBuildyear()));
        house.setHousecondition(houseform.getHouseCondition());
        house.setHousesize(Double.parseDouble(houseform.getHouseSize()));
        
        return house;
    }
    
    @Override
    public Seller createSeller(HouseForm houseform) {
        Seller seller = new Seller();
        seller.setEmail(houseform.getSellerEmail());
        seller.setName(houseform.getSellerName());
        seller.setPhoneNum(houseform.getSellerPhoneNum());
        
        return seller;
    }
   
  
}
    
    
    
