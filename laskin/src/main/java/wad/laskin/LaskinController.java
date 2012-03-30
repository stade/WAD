/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.laskin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tatutahv
 */

@Controller
public class LaskinController {
    
    private int num;
    private double dnum;
    
    @RequestMapping("summa")
    public String sumCount(Model model, @RequestParam Integer eka, @RequestParam Integer toka) {
        
        num = eka + toka;
        
        model.addAttribute("tulos", num);
        
        return "laskin";
    }
    
    @RequestMapping("kerto")
    public String multibly(Model model, @RequestParam Integer eka, @RequestParam Integer toka) {
        
        num = eka * toka;
        
        model.addAttribute("tulos", num);
        
        return "laskin";
    }
    @RequestMapping("jako")
    public String div(Model model, @RequestParam Double eka, @RequestParam Double toka) {
        
        dnum = eka/toka;
        
        model.addAttribute("tulos", dnum);
        
        return "laskin";
        
    }
    
}
