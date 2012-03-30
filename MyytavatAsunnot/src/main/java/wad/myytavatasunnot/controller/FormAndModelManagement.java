/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.myytavatasunnot.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.myytavatasunnot.domain.House;
import wad.myytavatasunnot.domain.HouseForm;
import wad.myytavatasunnot.domain.Seller;
import wad.myytavatasunnot.service.FormService;
import wad.myytavatasunnot.service.HouseService;
import wad.myytavatasunnot.service.SellerService;

/**
 *
 * @author stade
 */
@Controller
public class FormAndModelManagement {

    @Autowired
    private FormService formservice;
    @Autowired
    private SellerService sellerservice;
    @Autowired
    private HouseService houseservice;
    
    
 
    @RequestMapping(value = "/HouseForm", method = RequestMethod.GET)
    public String getHouseForm(Model model) {
        model.addAttribute("HouseForm", new HouseForm());
        //model.addAttribute("", formservice.list());
        return "HouseForm";
    }
    
    @RequestMapping(value = "/HouseForm", method = RequestMethod.POST)
    public String manageHouseForm(@Valid @ModelAttribute("HouseForm") HouseForm houseform, BindingResult result) {
        if(result.hasErrors()) {
            return "HouseForm";
         }
        
        House house;
        Seller seller;
         
        house = formservice.createHouse(houseform);
        seller = formservice.createSeller(houseform);

        houseservice.add(house);
        sellerservice.add(seller);
        
        return "redirect:/houses";
    }
    /*
      @RequestMapping("")
    public String nayta() {
        // oletus, ohjataan kaikki pyynnöt listaa-osoitteeseen
       return "redirect:/updateChat";
   
    }
    * 
    * 
    */
}