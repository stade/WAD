/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.myytavatasunnot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.myytavatasunnot.service.HouseService;


/**
 *
 * @author stade
 */
@Controller
public class HouseManagement {

    @Autowired
    HouseService houseservice;
    
    
    
    @RequestMapping("houses")
    public String showHouses(Model model) {
        
        model.addAttribute("houses", houseservice.list());
        
        return "House";
    }

   
}
