package wad.myytavatasunnot.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *
 * @author stade
 */
public class HouseForm {
    
    @NotNull(message="Myyjän nimi-kenttä ei saa olla tyhjä")
    @Size(min=1, max=50, message="Myyjän saa olla maksimissaan 50 merkkiä!")       
    @Pattern(regexp="[a-zA-Z]+\\s.[a-zA-Z]+",
          message="Myyjän nimi-kentän tulee muodostua vain kirjaimista")
    private String sellerName;
    @NotNull(message="Puhelinnumero-kenttä ei saa olla tyhjä")
    @Size(min=1, max=12, message="Puhelinnumerossa saa olla maksimissaan 12 numeroa")       
    @Pattern(regexp=".\\+.[0-9]+",
          message="Puhelinnumeron tulee muodostua numeroista")
    private String sellerPhoneNum;
    @NotNull(message="Sähköpostikenttä ei saa olla tyhjä")
    @Size(min=1, max=300, message="Sähköpostissa saa olla maksimissaan 300 merkkiä!")       
    @Pattern(regexp=".+@.+\\.[a-z]+",
          message="Sähköposti sisältää vääränlaisia merkkejä")
    private String sellerEmail;
    @NotNull(message="Asunnon koko kenttä ei saa olla tyhjä")
    @Size(min=1, max=100000, message="Asunnon koko on liian suuri")       
    @Pattern(regexp="[0-9]+\\.[0-9]+",
          message="Asunnon koko saa muodostua vain numeroista")
    private String houseSize;
    @NotNull(message="Osoite-kentän sisältö ei saa olla tyhjä")
    @Size(min=1, max=300, message="Osoite kentässä saa olla maksimissaan 300 merkkiä!")       
    @Pattern(regexp="[a-zA-Z0-9]+.\\s.+",
          message="Osoitteen tulee muodostua vain kirjaimista ja numeroista")
    private String houseAddress;
    @NotNull(message="Rakennusvuosi-kentän sisältö ei saa olla tyhjä")
    @Size(min=4, max=4, message="Rakennusvuoden tulee muodostua 4 numerosta!")       
    @Pattern(regexp="[0-9]+",
          message="Rakennusvuoden tulee muodostua numeroista")
    private String    buildyear;
    
    @NotNull(message="Huoneen kunnon sisältö ei saa olla tyhjä")
    @Size(min=1, max=300, message="Huoneen kunnossa saa olla maksimissaan 300 merkkiä!")       
    @Pattern(regexp="[a-zA-Z]+",
          message="Huoneen kunnon tulee muodostua vain kirjaimista")
         
    private String houseCondition;

    public String getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(String buildyear) {
        this.buildyear = buildyear;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(String houseCondition) {
        this.houseCondition = houseCondition;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }


    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPhoneNum() {
        return sellerPhoneNum;
    }

    public void setSellerPhoneNum(String sellerPhoneNum) {
        this.sellerPhoneNum = sellerPhoneNum;
    } 
}
