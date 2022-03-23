package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.user.User;
import ls.hvacaretaker.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.relation.RoleNotFoundException;

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
    public String processRegister(User user, Model model) {
        try {
            userService.saveNewUser(user);
        } catch (RoleNotFoundException e) {
            e.getMessage();
        }

        model.addAttribute("message", new Message("Sukces!", "Pomyślnie zarejestrowano nowego użytkownika."));
        return "message";
    }
}
