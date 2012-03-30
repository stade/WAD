package wad.spring.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.service.RoleService;
import wad.spring.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "*")
    public String home() {
        return "admin/home";
    }
    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String manageForm(@ModelAttribute User user) {
        Long roleId = roleService.getRoleId("student");
        
        System.out.println("roleID:" + roleId);
        
        userService.create(user, roleId);
        
        return "admin/home";
    }
    
}
