package wad.huone.database;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;




@Repository
public class JPAHenkiloDao implements HenkiloDao {

    @PersistenceContext
    EntityManager entityManager;
      

    @Override
    public void create(Henkilo instance) {
        entityManager.merge(instance);
    }

    @Override
    public Henkilo read(int id) {
        return entityManager.find(Henkilo.class, id);
    }

    @Override
    public void delete(Henkilo instance) {
        entityManager.remove(instance);
    }

    @Override
    public Henkilo update(Henkilo instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<Henkilo> listHenkilot() {
        Query q = entityManager.createQuery("SELECT h FROM Henkilo h");
        return q.getResultList();
    }

    @Override
    public void addHuone(Integer huoneId, Integer henkiloId) {
        Henkilo henkilo;
        Huone huone;
        
         huone = entityManager.find(Huone.class, huoneId);
         henkilo = entityManager.find(Henkilo.class, henkiloId);
         
         henkilo.setHuone(huone);

         entityManager.merge(henkilo);
         
         
    }

    @Override
    public Huone getHuone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addHenkilo(Integer henkiloId, Integer huoneId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
}
