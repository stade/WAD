package wad.huone.database;


import java.util.List;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;


public interface HuoneDao extends DAO<Huone> {
    public List<Henkilo> listHenkilot(Integer huoneId);
    public List<Huone> listHuoneet();

    @Override
    public void create(Huone huone);
    
    @Override
    public void addHenkilo(Integer henkiloId, Integer huoneId);




}
