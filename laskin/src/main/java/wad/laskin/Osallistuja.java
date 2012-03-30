/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.laskin;

/**
 *
 * @author tatutahv
 */
public class Osallistuja {
    private String nimi;
    private String email;
    private String osallistuuKilpailuun;
    
    public Osallistuja() {
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsallistuuKilpailuun() {
        return osallistuuKilpailuun;
    }

    public void setOsallistuuKilpailuun(String osallistuuKilpailuun) {
        this.osallistuuKilpailuun = osallistuuKilpailuun;
    }

    public Osallistuja(String nimi, String email, String osallistuuKilpailuun) {
        this.nimi = nimi;
        this.email = email;
        this.osallistuuKilpailuun = osallistuuKilpailuun;
    }
}
