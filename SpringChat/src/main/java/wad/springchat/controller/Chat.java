/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.springchat.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.springchat.domain.ChatMessage;
import wad.springchat.service.MessageService;

/**
 *
 * @author stade
 */
@Controller
public class Chat {

    @Autowired
    private MessageService messageService;
    
    private String forwardTo;

    private String checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        
         if (session.getAttribute("account") != null) {
             return forwardTo = "Chat";
             
         }

        return forwardTo = "redirect:/login";

    }

    @RequestMapping("ShowChat")
    public String showChat(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        forwardTo = checkLogin(request,response);

        return forwardTo;

    }
    @RequestMapping ("updateChat") 
    public String updateChat(Model model) {
        model.addAttribute("messages", messageService.list());
        
    
        return "Chat";
        
    }

    @RequestMapping(value = "addMessage", method = RequestMethod.POST)
    public String addMessage(@ModelAttribute ChatMessage msg, HttpServletRequest request) {

         
         msg.setContent(request.getSession().getAttribute("account") + ": " + msg.getContent());
         
         messageService.add(msg);

        return "redirect:/updateChat";
    }
        
      @RequestMapping("*")
    public String nayta() {
        // oletus, ohjataan kaikki pyynnöt listaa-osoitteeseen
        return "redirect:/updateChat";
   
    }
}