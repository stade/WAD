package wad.myytavatasunnot.service;

import java.util.Queue;
import wad.myytavatasunnot.domain.House;



public interface HouseService {
    public void add(House house);
    public Queue<House> list();
    public void delete(int houseId);
}