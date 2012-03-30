package wad.huone.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.huone.domain.Henkilo;
import wad.huone.domain.Huone;

    
@Repository
public class JPAHuoneDao implements HuoneDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Huone instance) {
        entityManager.merge(instance);
    }

    @Override
    public Huone read(int id) {
        return entityManager.find(Huone.class, id);
    }

    @Override
    public void delete(Huone instance) {
        entityManager.remove(instance);
    }

    @Override
    public Huone update(Huone instance) {
        return entityManager.merge(instance);
    }
    public Huone addHenkilo(Huone instance) {
        return entityManager.merge(instance);
 
        
    }

    @Override
    public List<Huone> listHuoneet() {
        Query q = entityManager.createQuery("SELECT h FROM Huone h");
        return q.getResultList();
    }

    @Override
    public void addHenkilo(Integer henkiloId, Integer huoneId) {
         Henkilo henkilo;
         Huone huone;
        
         huone = entityManager.find(Huone.class, huoneId);
         henkilo = entityManager.find(Henkilo.class, henkiloId);
         
         huone.setHenkilot(henkilo);
         entityManager.merge(huone);
      
         
         
    }

    @Override
    public List<Henkilo> listHenkilot(Integer huoneId) {
        
        Huone huone;
        
        String kysely = "SELECT h FROM Huone h WHERE h.id = :id";
        Query q = entityManager.createQuery(kysely);
        q.setParameter("id", huoneId);
        huone = (Huone)q.getSingleResult();
        
        return huone.getHenkilot();
        
    }
    
    @Override
    public void addHuone(Integer huoneId, Integer henkiloId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
