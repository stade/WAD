package wad.spring.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class WorldServiceImpl implements WorldService {

    private String lastInfo = null;

    @Override
    @Async
    public void request() {
        URLConnection conn = null;
        Scanner sc = null;
        
        try {

            conn = new URL("http://t-avihavai.users.cs.helsinki.fi/slow/Service").openConnection();

            sc = new Scanner(conn.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(WorldServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (sc.hasNextLine()) {
            lastInfo = sc.nextLine();
        }

    }

    @Override
    public String read() {
        return lastInfo;
    }
}