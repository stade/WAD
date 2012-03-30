package wad.huone.domain;


import java.io.Serializable;
import javax.persistence.*;



@Entity
public class Henkilo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    private String nimi;
    private String osoite;
    private String puhnro;
    

    @ManyToOne 
    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="HUONE_ID")
    private Huone huone;
     

    public Henkilo() {
       
    }

    public Huone getHuone() {
        return huone;
    }

    public void setHuone(Huone huone) {
        this.huone = huone;
    }

    public int getId() {
        return id;
    }


    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getPuhnro() {
        return puhnro;
    }

    public void setPuhnro(String puhnro) {
        this.puhnro = puhnro;
    }

    
}
