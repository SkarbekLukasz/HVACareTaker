package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.user.User;
import ls.hvacaretaker.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user, Model model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setAccountActivation(false);
        user.setAccountExpiration(true);
        user.setAccountLock(true);
        user.setCredentialExpiration(true);
        userRepository.save(user);
        model.addAttribute("message", new Message("Sukces!", "Pomyślnie zarejestrowano nowego użytkownika."));
        return "message";
    }
}
