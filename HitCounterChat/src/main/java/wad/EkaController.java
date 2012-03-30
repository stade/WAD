package wad;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EkaController {

    private int visitCount = 0;

    @RequestMapping("eka")
    public String heiSpring(Model model, HttpSession session) {
        System.out.println("Heippa!");

        if (session.getAttribute("kaynnit") != null) {

            visitCount = (Integer) session.getAttribute("kaynnit");
            visitCount++;
            session.setAttribute("kaynnit", visitCount);

        }
        else {
            session.setAttribute("kaynnit", 1);
        }
        
        
        
        model.addAttribute("viesti", visitCount);
        

        return "index.jsp";
    }
}