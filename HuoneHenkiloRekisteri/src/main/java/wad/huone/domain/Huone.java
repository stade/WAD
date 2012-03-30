package wad.huone.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Huone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    private String tunnus;

    private int kerros;

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    private Double kapasiteetti;

    public Huone() {
    }

    public int getId() {
        return id;
    }

    public int getKerros() {
        return kerros;
    }

    

    public void setKerros(int kerros) {
        this.kerros = kerros;
    }

    public Double getKapasiteetti() {
        return kapasiteetti;
    }

    public void setKapasiteetti(Double kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }
}
