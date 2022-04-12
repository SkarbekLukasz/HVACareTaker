package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.producent.ProducentDto;
import ls.hvacaretaker.producent.ProducentNotFoundException;
import ls.hvacaretaker.producent.ProducentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Kontroler obsługujący adresy /userpanel/searchproducent
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class SearchProducentController {

    private final ProducentService producentService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param producentService warstwa usług typu Producent
     */
    public SearchProducentController(ProducentService producentService) {
        this.producentService = producentService;
    }

    /**
     * Wyszukuje i przesyła do modelu widoku listę wskazanych producentów
     * Zwraca szablon widoku /searchproducent
     *
     * @param search wyszukiwana fraza
     * @param model  model widoku
     * @return szablon widoku /searchproducent
     */
    @GetMapping("/userpanel/searchproducent")
    public String getSearchProducent(@RequestParam(required = false) String search, Model model) {
        if(search != null) {
            model.addAttribute("searchquery", search);
            List<ProducentDto> producentDtos = producentService.findSpecificProducents(search);
            model.addAttribute("producents", producentDtos);
            return "searchproducent";
        }
        return "searchproducent";
    }

    /**
     * Wyświetla szczegółowe dane na temat producenta o wskazanym id.
     *
     * @param id    id producenta
     * @param model model widoku
     * @return szablon widoku /viewproducent
     */
    @GetMapping("/userpanel/producent/{id}/view")
    public String viewProducentDetails(@PathVariable Long id, Model model) {
        ProducentDto producentFound;
        try {
            producentFound = producentService.findProducentByid(id);
        } catch (ProducentNotFoundException e) {
            model.addAttribute("message", new Message("Błąd wyszukiwania", "Nie znaleziono producenta o podanym ID."));
            return "message";
        }
        model.addAttribute("producent", producentFound);
        return "viewproducent";
    }

    /**
     * Metoda pozwala na usunięcie producenta o wskazanym id z bazy danych.
     *
     * @param id    id producenta
     * @param model model widoku
     * @return szablon widoku /message
     */
    @GetMapping("/userpanel/producent/{id}/delete")
    public String deleteProducent(@PathVariable Long id, Model model) {
        try {
            producentService.deleteSpecificProducent(id);
        } catch (ProducentNotFoundException e) {
            model.addAttribute("message", new Message("Brak producenta", "Nie znaleziono producenta o wskazanym ID"));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Producent został pomyślnie usunięty z bazy"));
        return "message";
    }

}
