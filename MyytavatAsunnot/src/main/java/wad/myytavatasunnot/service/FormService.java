package wad.myytavatasunnot.service;

import wad.myytavatasunnot.domain.House;
import wad.myytavatasunnot.domain.HouseForm;
import wad.myytavatasunnot.domain.Seller;



public interface FormService {
    
    public House createHouse(HouseForm houseform);
    public Seller createSeller(HouseForm houseform);
  
}