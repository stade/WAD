package wad.olut.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wad.olut.domain.Olut;
import wad.olut.service.OlutPalvelu;

@Controller
public class OlutController {

    @Autowired
    private OlutPalvelu olutPalvelu;


    @RequestMapping(method = RequestMethod.GET, value = "olut")
    public String listaaOluet(Model model) {
        model.addAttribute("oluet", olutPalvelu.listaaOluet());
        return "listaus";
    }

    @RequestMapping(method = RequestMethod.GET, value = "olut.json")
    @ResponseBody
    public List<Olut> listaaJsonOluet(Model model) {
        return olutPalvelu.listaaOluet();
    }

    @RequestMapping(method = RequestMethod.GET, value = "olut/{olutId}.json")
    @ResponseBody
    public Olut naytaJsonOlut(Model model, @PathVariable Integer olutId) {
        return olutPalvelu.annaOlut(olutId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "olut/{olutId}")
    public String naytaOlut(Model model, @PathVariable Integer olutId) {
        model.addAttribute("olut", olutPalvelu.annaOlut(olutId));
        return "olutnakyma";
    }
   

    @RequestMapping(method = RequestMethod.POST, value = "olut")
    public String lisaaOlut(@ModelAttribute Olut olut) {
        olut = olutPalvelu.lisaaOlut(olut);
        return "redirect:/olut/" + olut.getId(); // luotu olut
    }
    
    
    
    @RequestMapping(method = RequestMethod.POST, value = "olut.json", consumes = "application/json")
    public String lisaaJsonOlut(@RequestBody Olut olut) {
        olut = olutPalvelu.lisaaOlut(olut);
        return "redirect:/olut/" + olut.getId(); // luotu olut
    
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "olut/{olutId}")
    public String poistaOlut(@PathVariable Integer olutId) {
        olutPalvelu.poistaOlut(olutId);
        return "redirect:/olut/";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "olut/{olutId}")
    public String muokkaaTaiLisaaOlut(@ModelAttribute Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" + olut.getId(); // luotu tai muokattu olut
    }

    @RequestMapping(method = RequestMethod.PUT, value = "olut/{olutId}.json", consumes = "application/json")
    public String muokkaaTaiLisaaJsonOlut(@RequestBody Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" + olut.getId(); // luotu tai muokattu olut
    }
}