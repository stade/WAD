package wad.henkilo.service;


import java.util.List;
import wad.henkilo.domain.Henkilo;


public interface HenkiloPalvelu {
    public void lisaa(Henkilo henkilo);
    public List<Henkilo> listaa();
    public void poista(int id);
}
