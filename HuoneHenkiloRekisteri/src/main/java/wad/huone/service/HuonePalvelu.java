package wad.huone.service;

import java.util.List;
import wad.huone.domain.Huone;

public interface HuonePalvelu {
    public void lisaa(Huone huone);
    public List<Huone> listaa();
    public void poista(int id);

}
