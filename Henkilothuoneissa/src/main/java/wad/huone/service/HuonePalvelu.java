package wad.huone.service;

import java.util.List;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;

public interface HuonePalvelu {
    public void lisaa(Huone huone);
    public List<Huone> listaa();
    public List<Henkilo> listHenkilot(Integer huoneId);
    public void poista(int id);
    public void lisaaHenkilo(Integer henkiloId, Integer huoneId);

}
