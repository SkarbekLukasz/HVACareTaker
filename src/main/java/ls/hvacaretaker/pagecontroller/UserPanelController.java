package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.commonlogic.HermeticTestCheck;
import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserPanelController {
    private final HermeticTestCheck hermeticTestCheck;

    public UserPanelController(HermeticTestCheck hermeticTestCheck) {
        this.hermeticTestCheck = hermeticTestCheck;
    }

    @GetMapping("/userpanel")
    public String getUserPanel(Model model) {
        List<Device> incomingHermeticTests = hermeticTestCheck.findIncomingTests();
        model.addAttribute("hermetictests", incomingHermeticTests);
        return "userpanel";
    }
}
