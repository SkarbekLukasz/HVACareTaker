package ls.hvacaretaker.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errorMsg", "Twój login lub hasło są nieprawidłowe");
        }

        if (logout != null) {
            model.addAttribute("msg", "Zostałeś pomyślnie wylogowany");
        }
        return "login";
    }
}
