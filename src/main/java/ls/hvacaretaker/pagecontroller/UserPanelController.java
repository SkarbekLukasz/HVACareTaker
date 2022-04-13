package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.commonlogic.HermeticTestCheck;
import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *  Kontroler obsługujący adres /userpanel wyświetlający zbliżające się kontrole szczelności.
 *
 *  @author Luke
 *  @version 1.0
 *  @since 1.0
 */
@Controller
public class UserPanelController {
    private final HermeticTestCheck hermeticTestCheck;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param hermeticTestCheck warstwa usługi sprawdzająca zbliżające się terminy kontroli sczelności
     */
    public UserPanelController(HermeticTestCheck hermeticTestCheck) {
        this.hermeticTestCheck = hermeticTestCheck;
    }

    /**
     * Wyświetla szablon widoku /userpanel z zbliżającymi się kontrolami szczelności.
     *
     * @param model model widoku
     * @return szablon widoku /userpanel
     */
    @GetMapping("/userpanel")
    public String getUserPanel(Model model) {
        List<Device> incomingHermeticTests = hermeticTestCheck.findIncomingTests();
        model.addAttribute("hermetictests", incomingHermeticTests);
        return "userpanel";
    }
}
