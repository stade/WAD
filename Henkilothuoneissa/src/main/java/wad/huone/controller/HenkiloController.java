package wad.huone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.huone.domain.Henkilo;
import wad.huone.service.HenkiloPalvelu;



@Controller
public class HenkiloController {

    @Autowired
    private HenkiloPalvelu henkiloPalvelu;

    @RequestMapping("henkilo")
    public String nayta() {
        return "redirect:/hlistaa";
    }

    @RequestMapping("hlistaa")
    public String listaa(Model model) {
        model.addAttribute("henkilot", henkiloPalvelu.listaa());
        return "henkilot";
    }

    @RequestMapping(value = "hlisaa", method = RequestMethod.POST)
    public String lisaa(@ModelAttribute Henkilo henkilo) {
        henkiloPalvelu.lisaa(henkilo);
        return "redirect:/hlistaa";
    }

    @RequestMapping(value = "hpoista/{henkiloId}")
    public String poista(@PathVariable Integer henkiloId) {
        henkiloPalvelu.poista(henkiloId);
        return "redirect:/hlistaa";
    }
}
