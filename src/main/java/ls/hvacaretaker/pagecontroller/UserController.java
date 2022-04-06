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

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

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

    @GetMapping("/user/{id}/changepassword")
    public String changePasswordForm(@PathVariable Long id, Model model) {
        model.addAttribute("userid", id);
        return "passwordchanger";
    }

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
