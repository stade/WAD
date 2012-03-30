package wad.huone.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Huone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    //@Column(name="HUONE_ID")
    private int id;
    private String tunnus;
    private int kerros;
    private int kapasiteetti;
    //@OneToMany(mappedBy = "huone")
    //private List<Henkilo> henkilot;
    
    @OneToMany(mappedBy = "huone")
    private List<Henkilo> henkilot;

    public String getTunnus() {
        return tunnus;
    }

    public List<Henkilo> getHenkilot() {
        return henkilot;
    }

    public void setHenkilot(Henkilo henkilo) {
        this.henkilot.add(henkilo);
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

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

    public int getKapasiteetti() {
        return kapasiteetti;
    }

    public void setKapasiteetti(int kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }
}
