package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.refrigerant.RefrigerantAlreadyExistException;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Kontroler obsługujący adresy userpanel/addrefrigerant
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class AddRefrigerantController {

    private final RefrigerantService refrigerantService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param refrigerantService warstwa usług typu Refrigerant
     */
    public AddRefrigerantController(RefrigerantService refrigerantService) {
        this.refrigerantService = refrigerantService;
    }

    /**
     * Obsługuje adres /userpanel/addproducent i zwraca szablon widoku /addrefrigerant
     *
     * @param model model widoku
     * @return szablon widoku /addrefrigerant
     */
    @GetMapping("/userpanel/addrefrigerant")
    public String addNewRefrigerant(Model model) {
        return "addrefrigerant";
    }

    /**
     * Metoda obsługuje utworzenie nowego czynnika chłodniczego za pomocą danych z formularza i zapisanie w bazie danych.
     * Po pomyślnym zapisie wyświetlany jest komunikat o pomyślnym przeprowadzeniu operacji.
     *
     * @param refrigerantname nazwa czynnika chłodniczego
     * @param refrigerantgwp  GWP czynnika chłodniczeog
     * @param model           model widoku
     * @return szablon widoku /message
     */
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
