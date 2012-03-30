/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.springchat.controller;



import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author stade
 */
@Controller
public class Login {

    @RequestMapping("login")
    public String showLogin() {
        return "Login";
    }

    @RequestMapping(value = "login",  method = RequestMethod.POST)
    public String getLoginInfo(@RequestParam("account") String account, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();


        if (account != null && account.length() > 3 && account.length() < 9) {


            session.setAttribute("account", account);
            resp.setStatus(302);
            resp.setHeader("Location", req.getContextPath() + "/ShowChat");
            resp.flushBuffer();

        }


        return "Login";

    }
}
