/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.laskin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author tatutahv
 */

@Controller
public class OsallistuController {
    
    
    @RequestMapping(value="osallistu", method=RequestMethod.POST)
    public String osallistu(Model model, @ModelAttribute Osallistuja osallistuja) {
        model.addAttribute("osallistuja", osallistuja);
        
        System.out.println("jee");
        
        return "osallistu";
    }
    
}
