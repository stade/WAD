package wad.myytavatasunnot.service;


import java.util.LinkedList;
import java.util.Queue;
import org.springframework.stereotype.Service;
import wad.myytavatasunnot.domain.House;


@Service
public class SimpleHouseService implements HouseService {

    private Queue<House> houses = new LinkedList();

    @Override
    public void add(House house) {
        if (this.houses.size() < 10) {

            this.houses.offer(house);

        } else {
            houses.remove();
            houses.offer(house);
        }
    }
    @Override
    public Queue<House> list() {
        return houses;
    }

    @Override
    public void delete(int houseId) {
        
        House delThisHouse = null;
        
        for (House house : houses ){
            if (house.getId() == houseId) {
                delThisHouse = house;
                break;
            }
        }
        
        if (delThisHouse != null) {
            houses.remove(delThisHouse);
        }
    }
}
