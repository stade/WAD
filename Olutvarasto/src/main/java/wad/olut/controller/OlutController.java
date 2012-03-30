package wad.olut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET, value = "olut/{olutId}")
    public String naytaOlut(Model model, @PathVariable Integer olutId) {
        model.addAttribute("olut", olutPalvelu.annaOlut(olutId));
        return "olutnakyma";
    }

    @RequestMapping(method = RequestMethod.POST, value = "olut")
    public String lisaaOlut(@ModelAttribute Olut olut) {
        olutPalvelu.lisaaOlut(olut);
        return "redirect:/olut/" + olut.getId(); // luotu olut
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "olut/{olutId}")
    public String poistaOlut(@PathVariable Integer olutId) {
        olutPalvelu.poistaOlut(olutId);
        return "redirect:/olut";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "olut/{olutId}")
    public String muokkaaTaiLisaaOlut(@ModelAttribute Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" + olut.getId(); // luotu tai muokattu olut
    }
}