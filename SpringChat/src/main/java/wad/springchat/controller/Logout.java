/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.springchat.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author stade
 */

@Controller
public class Logout {

    @RequestMapping("handleLogout")
    public String handleLogout(HttpSession session) {
        
        session.invalidate();
        
        return "Logout";
        
    }
}