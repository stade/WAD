import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml", 
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class HomeIntegrationTest {
    
    MockMvc mockMvc;
    
    @Before
    public void setup() {
        String[] contextLoc = {"file:src/main/webapp/WEB-INF/spring-context.xml",
            "file:src/main/webapp/WEB-INF/spring-database.xml"};
        String warDir = "src/main/webapp";
        mockMvc = MockMvcBuilders.xmlConfigSetup(contextLoc).
                configureWebAppRootDir(warDir, false).build();
    }
    
    @Test 
    public void requestToHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.model().size(2)).
                andExpect(MockMvcResultMatchers.model().attributeExists("player")).
                andExpect(MockMvcResultMatchers.model().attributeExists("teams")).
                andExpect(MockMvcResultMatchers.redirectedUrl("/WEB-INF/view/list.jsp"));
        
    }
}