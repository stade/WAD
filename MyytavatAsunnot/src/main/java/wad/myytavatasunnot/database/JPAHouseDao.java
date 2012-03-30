package wad.myytavatasunnot.database;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import wad.myytavatasunnot.domain.House;





@Repository
public class JPAHouseDao implements HouseDao {

    @PersistenceContext
    EntityManager entityManager;
      

    @Override
    public void create(House instance) {
        entityManager.merge(instance);
    }

    @Override
    public House read(int id) {
        return entityManager.find(House.class, id);
    }

    @Override
    public void delete(House instance) {
        entityManager.remove(instance);
    }

    @Override
    public House update(House instance) {
        return entityManager.merge(instance);
    }

    @Override
    public List<House> listHouses() {
        Query q = entityManager.createQuery("SELECT h FROM House h");
        return q.getResultList();
    }
 
}
