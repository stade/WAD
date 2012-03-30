
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;
import wad.spring.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl() {
    }

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findOne(Long id) {
        return this.teamRepository.findOne(id);
    }

    @Override
    public void create(Team team) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Team> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}