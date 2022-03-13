package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.producent.ProducentAlreadyExistException;
import ls.hvacaretaker.producent.ProducentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddProducentController {

    private final ProducentService producentService;

    public AddProducentController(ProducentService producentService) {
        this.producentService = producentService;
    }
    @GetMapping("/userpanel/addproducent")
    public String getAddProducent(Model model) {
        return "addproducent";
    }

    @PostMapping("/userpanel/addproducent/message")
    public String saveNewProducent(@RequestParam String producentname, Model model) {
        if(producentname == null) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu producenta", "Nie udało się pomyślnie dodać nowego producenta do bazy. Pole formularza było puste"));
            return "message";
        }
        try{
            producentService.save(producentname);
        } catch (ProducentAlreadyExistException e) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu producenta", "Producent o wskazanej nazwie już istnieje w bazie danych."));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Producent został pomyślnie dodany do bazy danych."));
        return "message";
    }
}
