package wad.huone.service;


import java.util.List;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;


public interface HenkiloPalvelu {
    public void lisaa(Henkilo henkilo);
    public List<Henkilo> listaa();
    public Huone getHuone();
    public void poista(int id);
    public void lisaaHuone(Integer huoneId, Integer henkiloId);
}
