package wad.huone.database;


import java.util.List;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;




public interface HenkiloDao extends DAO<Henkilo> {
    public Huone getHuone();
    public List<Henkilo> listHenkilot();
    
    
    @Override
    public void addHuone(Integer huoneId, Integer henkiloId);
    
    
}
