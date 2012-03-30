package wad.myytavatasunnot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 *
 * @author stade
 */

@Entity
public class House {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private double housesize;
    private String address;
    private int buildyear;
    private String housecondition;

    public House() {
    }
    
    
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(int buildyear) {
        this.buildyear = buildyear;
    }

    public String getHousecondition() {
        return housecondition;
    }

    public void setHousecondition(String housecondition) {
        this.housecondition = housecondition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHousesize() {
        return housesize;
    }

    public void setHousesize(double housesize) {
        this.housesize = housesize;
    }
    
}
