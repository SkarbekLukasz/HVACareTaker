package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.refrigerant.RefrigerantAlreadyExistException;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddRefrigerantController {

    private final RefrigerantService refrigerantService;

    public AddRefrigerantController(RefrigerantService refrigerantService) {
        this.refrigerantService = refrigerantService;
    }

    @GetMapping("/userpanel/addrefrigerant")
    public String addNewRefrigerant(Model model) {
        return "addrefrigerant";
    }

    @PostMapping("/userpanel/addrefrigerant/message")
    public String saveNewRefrigerant(@RequestParam String refrigerantname,
                                     @RequestParam int refrigerantgwp,
                                     Model model) {
        if(refrigerantname == null) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu czynnika", "Nie udało się pomyślnie dodać nowego czynnika chłodniczego do bazy danych."));
            return "message";
        }
        try {
            refrigerantService.saveNewRefrigerant(refrigerantname, refrigerantgwp);
        } catch (RefrigerantAlreadyExistException e) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu czynnika chłodniczego", "Czynnik chłodniczy o podanej nazwie już istnieje w bazie danych."));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Czynnik chłodniczy został pomyślnie dodany do bazy danych."));
        return "message";
    }
}
