
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stade
 */
class TeamRepositoryTestImpl implements TeamRepository {

    public TeamRepositoryTestImpl() {
    }

    @Override
    public List<Team> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Team> findAll(Sort sort) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Team> save(Iterable<? extends Team> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Team saveAndFlush(Team t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteInBatch(Iterable<Team> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<Team> findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Team save(Team t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Team findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean exists(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Team t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Iterable<? extends Team> itrbl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
