package wad.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.spring.service.WorldService;

@Controller
public class WorldController {
    
    @Autowired
    WorldService worldService;

    @RequestMapping(value = "/home")
    public String home(Model model) {
        
        worldService.request();
        
        model.addAttribute("lastInfo", worldService.read());
        
        return "home";
    }
}
