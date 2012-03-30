package wad.henkilo.database;


import java.util.List;
import wad.henkilo.domain.Henkilo;





public interface HenkiloDao extends DAO<Henkilo> {
    public List<Henkilo> list();
}
