package wad.myytavatasunnot.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.myytavatasunnot.domain.Seller;

    
@Repository
public class JPASellerDao implements SellerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Seller instance) {
        entityManager.merge(instance);
    }

    @Override
    public Seller read(int id) {
        return entityManager.find(Seller.class, id);
    }

    @Override
    public void delete(Seller instance) {
        entityManager.remove(instance);
    }

    @Override
    public Seller update(Seller instance) {
        return entityManager.merge(instance);
    }
    public Seller addHenkilo(Seller instance) {
        return entityManager.merge(instance);
 
        
    }

    @Override
    public List<Seller> list() {
        Query q = entityManager.createQuery("SELECT h FROM Seller h");
        return q.getResultList();
    }

}
