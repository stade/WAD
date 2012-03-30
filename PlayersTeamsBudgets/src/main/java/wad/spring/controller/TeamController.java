package wad.spring.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.spring.domain.AnnualBudget;
import wad.spring.domain.Team;
import wad.spring.service.AnnualBudgetService;
import wad.spring.service.TeamService;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private AnnualBudgetService budgetService;

    @RequestMapping(value = "/team")
    public String add(@ModelAttribute Team team) {
        teamService.create(team);
        return "redirect:/home";
    }
     @RequestMapping(value = "/budget", method = RequestMethod.GET)
    public String getBudget(Model model) {
        model.addAttribute("budget", new AnnualBudget());
        model.addAttribute("teams", teamService.list());
        return "budget";
    }

    @RequestMapping(value = "/budget", method = RequestMethod.POST)
    public String addBudget(@Valid @ModelAttribute("budget") AnnualBudget annualBudget, BindingResult result,
            @RequestParam Long teamId, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("teams", teamService.list());
            return "budget";
        }
        budgetService.saveOrUpdate(annualBudget, teamId);
        return "redirect:/home";
    
 
    }
}
