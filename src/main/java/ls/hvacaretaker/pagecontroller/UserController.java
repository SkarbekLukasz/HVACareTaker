package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.user.User;
import ls.hvacaretaker.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

/**
 * Kontroler obsługujący adresy rejestracji i zmiany hasła użytkownika.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UserController {
    private final UserService userService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param userService warstwa usług typu User
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Przesyłą widok z formularzem rejestracji nowego użytkownika.
     *
     * @param model model widoku
     * @return szablon widoku /register
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Metoda przyjmuje parametry z danymi użytkownika z formularza i zapisuje go do bazy danych.
     *
     * @param user          obiekt typu User przesłany z formularza
     * @param bindingResult obiekt przechowujący błędy podczas rejestracji
     * @param model         model widoku
     * @return szablon widoku /message
     */
    @PostMapping("/process_register")
    public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "register";
        } else {
            try {
                userService.saveNewUser(user);
            } catch (RoleNotFoundException e) {
                model.addAttribute("message", new Message("Błąd", e.getMessage()));
                return "message";
            }

            model.addAttribute("message", new Message("Sukces!", "Pomyślnie zarejestrowano nowego użytkownika."));
            return "message";
        }
    }

    /**
     * Wyświetla formularz zmiany hasła
     *
     * @param id    numer id użytkownika
     * @param model model widoku
     * @return szablon widoku /passwordchanger
     */
    @GetMapping("/user/{id}/changepassword")
    public String changePasswordForm(@PathVariable Long id, Model model) {
        model.addAttribute("userid", id);
        return "passwordchanger";
    }

    /**
     * Zapisuje hasło zmienione przez uzytkownika.
     *
     * @param id          numer id
     * @param model       model widoku
     * @param oldPassword String z starym hasłem
     * @param newPassword String z nowym hasłem
     * @return szablon widoku /message
     */
    @PostMapping("/user/{id}/changepassword")
    public String changePasswordPosted(@PathVariable Long id,
                                       Model model,
                                       @RequestParam String oldPassword,
                                       @RequestParam String newPassword) {
        try {
            userService.changeUserPassword(id, oldPassword, newPassword);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", new Message("Błąd!", "Podano niewłaściwe obecne hasło."));
            return "message";
        }
            model.addAttribute("message", new Message("Sukces!", "Hasło zostało zmienione."));
        return "message";
    }
}
