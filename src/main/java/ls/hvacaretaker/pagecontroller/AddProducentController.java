package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.producent.ProducentAlreadyExistException;
import ls.hvacaretaker.producent.ProducentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Kontroler obsługujący adresy userpanel/addproducent
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class AddProducentController {

    private final ProducentService producentService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param producentService warstwa usług typu Producent
     */
    public AddProducentController(ProducentService producentService) {
        this.producentService = producentService;
    }

    /**
     * Obsługuje adres /userpanel/addproducent i zwraca szablon widoku /addproducent
     *
     * @param model model widoku
     * @return szablon widoku /addproducent
     */
    @GetMapping("/userpanel/addproducent")
    public String getAddProducent(Model model) {
        return "addproducent";
    }

    /**
     * Metoda obsługuje dodawanie nowego producenta przez formularz.
     *
     * @param producentname nazwa producenta
     * @param contactInfo   dane kontaktowe producenta
     * @param model         model widoku
     * @return zwraca szablon widoku /message
     */
    @PostMapping("/userpanel/addproducent/message")
    public String saveNewProducent(@RequestParam String producentname, @RequestParam String contactInfo, Model model) {
        if(producentname == null) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu producenta", "Nie udało się pomyślnie dodać nowego producenta do bazy. Pole formularza było puste"));
            return "message";
        }
        try{
            producentService.save(producentname, contactInfo);
        } catch (ProducentAlreadyExistException e) {
            model.addAttribute("message", new Message("Błąd przy dodawaniu producenta", "Producent o wskazanej nazwie już istnieje w bazie danych."));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Producent został pomyślnie dodany do bazy danych."));
        return "message";
    }
}
