package wad.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.service.CredentialsService;
import wad.spring.service.RoleService;
import wad.spring.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CredentialsService CredentialsService;
    @Autowired
    UserDetailsService details;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "*")
    public String home(Model model) {


        String name = CredentialsService.getName();
        UserDetails userDetail = details.loadUserByUsername(name);

        model.addAttribute("name", name);
        model.addAttribute("username", userDetail.getUsername());

        return "student/home";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String manageForm(@ModelAttribute User user) {

        Long roleId = roleService.getRoleId("student");
        
        System.out.println(roleId);
        
        userService.create(user, roleId);

        return "student/home";
    }
}
