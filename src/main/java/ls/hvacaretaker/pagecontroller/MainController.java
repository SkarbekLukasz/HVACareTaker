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

/**
 * Kontroler obsługujący adresy ogołnie dostepne.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class MainController {
    private final EmailService emailService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param emailService klasa warstwy usług Email
     */
    public MainController(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Obsługuje adres główny aplikacji i zwraca index.html
     *
     * @param model model widoku
     * @return szablon widoku /index
     */
    @GetMapping("/")
    public String getMain(Model model) {
        return "index";
    }

    /**
     * Obsługuje adres /login i zwraca szablon widoku /login
     *
     * @param model  model widoku
     * @param error  treść błędów
     * @param logout treść wylogowania
     * @return szablon widoku /login
     */
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

    /**
     * Obsługuje adres /accountdetails
     *
     * @param model           model widoku
     * @param securityContext SecurityContext z danym uwierzytelniajaćymi użytkownika
     * @return szablon widoku /accountdetails
     */
    @GetMapping("/accountdetails")
    public String accountDetails(Model model, @CurrentSecurityContext SecurityContext securityContext) {
        CustomUserDetails userDetails = (CustomUserDetails) securityContext.getAuthentication().getPrincipal();
        model.addAttribute("userdetails", userDetails);
        return "accountdetails";
    }

    /**
     * Obsługuje adres /contact i zwraca szablon widoku /contact
     *
     * @param model model widoku
     * @return szablon widoku /contact
     */
    @GetMapping("/contact")
    public String contactInfo(Model model) {
        return "contact";
    }

    /**
     * Obsługuje żądanie POST pod adresem /contact i pozwala na wysłanie wiadomości kontaktowej od użytkownika do administracji portalu.
     *
     * @param emailinput  email kontaktowy do nadawcy
     * @param topicinput  tytuł wiadomości
     * @param messageinfo treść wiadomości
     * @param model       model widoku
     * @return szablon widoku /message
     */
    @PostMapping("/contact")
    public String sendContactMessage(@RequestParam String emailinput,
                                     @RequestParam String topicinput,
                                     @RequestParam String messageinfo,
                                     Model model) {
        emailService.sendMail("hvacaretaker@gmail.com", topicinput + " " + emailinput, messageinfo);
        model.addAttribute("message", new Message("Sukces!", "Wiadomość wysłana pomyślnie."));
        return "message";
    }

    /**
     * Obsługuje adres /info i zwraca szablon widoku /info
     *
     * @return szablon widoku /info
     */
    @GetMapping("/info")
    public String getInfoPage() {
        return "info";
    }
}
