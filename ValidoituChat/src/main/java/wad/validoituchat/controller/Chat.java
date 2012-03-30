/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.validoituchat.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.validoituchat.domain.ChatMessage;
import wad.validoituchat.service.MessageService;

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
             return forwardTo = "redirect:/ChatMessage";
             
         }

        return forwardTo = "redirect:/login";

    }

    @RequestMapping("/ShowChat")
    public String showChat(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        forwardTo = checkLogin(request,response);
        return forwardTo;

    }
 
    @RequestMapping(value = "/ChatMessage", method = RequestMethod.GET)
    public String getHenkilo(Model model) {
        model.addAttribute("ChatMessage", new ChatMessage());
        model.addAttribute("messages", messageService.list());
        return "Chat";
    }
    
    

    @RequestMapping(value = "/ChatMessage", method = RequestMethod.POST)
    public String addMessage(@Valid @ModelAttribute("ChatMessage") ChatMessage ChatMessage, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "Chat";
        }
         
         ChatMessage.setContent(request.getSession().getAttribute("account") + ": " + ChatMessage.getContent());
         
         messageService.add(ChatMessage);

        return "redirect:/ShowChat";
    }
    /*
      @RequestMapping("*")
    public String nayta() {
        // oletus, ohjataan kaikki pyynnöt listaa-osoitteeseen
       return "redirect:/updateChat";
   
    }
    * 
    * 
    */
}