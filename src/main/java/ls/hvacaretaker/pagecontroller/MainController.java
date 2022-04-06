package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.commonlogic.EmailService;
import ls.hvacaretaker.security.CustomUserDetails;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final EmailService emailService;

    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }

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

    @GetMapping("/accountdetails")
    public String accountDetails(Model model, @CurrentSecurityContext SecurityContext securityContext) {
        CustomUserDetails userDetails = (CustomUserDetails) securityContext.getAuthentication().getPrincipal();
        model.addAttribute("userdetails", userDetails);
        return "accountdetails";
    }

    @GetMapping("/contact")
    public String contactInfo(Model model) {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContactMessage(@RequestParam String emailinput,
                                     @RequestParam String topicinput,
                                     @RequestParam String messageinfo,
                                     Model model) {
        emailService.sendMail("hvacaretaker@gmail.com", topicinput + " " + emailinput, messageinfo);
        model.addAttribute("message", new Message("Sukces!", "Wiadomość wysłana pomyślnie."));
        return "message";
    }

    @GetMapping("/info")
    public String getInfoPage() {
        return "info";
    }
}
