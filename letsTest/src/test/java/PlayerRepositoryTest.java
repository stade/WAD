/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.spring.domain.Player;
import wad.spring.domain.Team;
import wad.spring.repository.PlayerRepository;
import wad.spring.repository.TeamRepository;

/**
 *
 * @author stade
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})
public class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void createIncrementsElementCountByOne() {
        long countAtStart = playerRepository.count();

        Player p = new Player();
        p.setName("Matti");
        playerRepository.save(p);

        long countAtEnd = playerRepository.count();
        Assert.assertTrue("Player count should be increased by one when adding an element.",
                countAtStart + 1 == countAtEnd);
    }

    @Test
    public void testAddingOneTeamByCount() {
        long countAtStart = teamRepository.count();

        Team t = new Team();
        t.setName("LeTeam");
        teamRepository.save(t);

        long countAtEnd = teamRepository.count();
        Assert.assertTrue("Team count shoud be increased by one when adding an team.",
                countAtStart + 1 == countAtEnd);


    }
    @Test
    public void testAddingOnePlayerByName() {

        Team tOld = new Team();
        Team tNew;
        List<Player> plist;
        Player newp;

        Player p = new Player();
        tOld.setName("Tiimi");
        p.setName("Juha");
        teamRepository.save(tOld);
        
        p = playerRepository.save(p);
        
        tOld.addPlayer(p); 
      
        teamRepository.save(tOld);

        tNew = teamRepository.findOne(tOld.getId());

        plist = tNew.getPlayers();

        newp = plist.get(0);
        
        Assert.assertEquals("should be the same", p.getName(), newp.getName());



    }
    @Test
    public void testAddingtTwoPlayrsToTeam() {

        long countAtStart = playerRepository.count();

        Team t = new Team();
        Player p1 = new Player();
        Player p2 = new Player();

        t.setName("Buffalo");
        p1.setName("Teemu");
        p2.setName("Jari");
        
        
        teamRepository.save(t);
        
        p1 = playerRepository.save(p1);
        p2 = playerRepository.save(p2);

        t.addPlayer(p1);
        t.addPlayer(p2);
        
        teamRepository.save(t);


        long countAtEnd = playerRepository.count();
        Assert.assertTrue("Playercount of team should be increased by two when adding two players.",
                countAtStart + 2 == countAtEnd);
    }
    
    @Test
    public void testAddingtTwoPlayrsToTeamAndThenRemove() {

        long countAtStart = playerRepository.count();

        Team t = new Team();
        Player p1 = new Player();
        Player p2 = new Player();

        t.setName("Winnipeg");
        p1.setName("Jutila");
        p2.setName("Timonen");
        
        
        teamRepository.save(t);
        
        p1 = playerRepository.save(p1);
        p2 = playerRepository.save(p2);

        t.addPlayer(p1);
        t.addPlayer(p2);

        t = teamRepository.save(t);
        
        t.removePlayer(p1);
        t.removePlayer(p2);
        
        playerRepository.delete(p1);
        playerRepository.delete(p2);
        
          
        teamRepository.delete(t);
        

        long countAtEnd = playerRepository.count();
        Assert.assertTrue("Playercount of team should be same as in start after adding 2 and removing 2 players start = " + countAtStart + " end = " + countAtEnd + "",
                countAtStart == countAtEnd);
    }
  
}