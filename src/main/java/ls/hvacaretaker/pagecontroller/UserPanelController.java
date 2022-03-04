package ls.hvacaretaker.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPanelController {

    @GetMapping("/userpanel")
    public String getUserPanel(Model model) {
        return "userpanel";
    }
}
