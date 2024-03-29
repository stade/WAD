package wad.varasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.varasto.domain.Esine;
import wad.varasto.service.EsinePalvelu;

@Controller
public class VarastoController {
    
    //private int count = 0;
    //private Esine esine = new Esine();

    @Autowired
    private EsinePalvelu esinePalvelu;

    @RequestMapping("*")
    public String nayta() {
        // oletus, ohjataan kaikki pyynnöt listaa-osoitteeseen
        return "redirect:/listaa";
    }

    @RequestMapping("listaa")
    public String listaa(Model model) {
        model.addAttribute("esineet", esinePalvelu.listaa());
        return "varasto";
    }
    @RequestMapping(value = "lisaa", method = RequestMethod.POST) 
    public String lisaa(@ModelAttribute Esine esine) {   
        esinePalvelu.lisaa(esine);

        return nayta();
    }
    @RequestMapping(value = "poista/{esineId}")
    public String poista(@PathVariable Integer esineId) {
        esinePalvelu.poista(esineId);  
        return nayta();
    }
    

}