
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Team;
import wad.spring.repository.TeamRepository;
import wad.spring.service.TeamService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})
public class TeamServiceTest {

    @Autowired
    TeamService teamService;

    @Configuration
    static class Config {

        // inject this into teamService
        @Bean
        public TeamRepository teamRepository() {
            return new TeamRepositoryTestImpl();
        }
    }

    @Test
    public void testNewTeamHasBeenCreated() {
        Team t = new Team();
        t.setName("Tiimi");
        teamService.create(t);

        List<Team> teams = teamService.list();
        Assert.assertTrue("", teams.size() == 1);
    }
    @Test
    public void testThatNameIsValidAfterTeamhasBeenCreated() {
        Team t = new Team();
        t.setName("Joukkue");
        teamService.create(t);
        
        
    }
}