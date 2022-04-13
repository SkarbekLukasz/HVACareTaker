package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.refrigerant.RefrigerantDto;
import ls.hvacaretaker.refrigerant.RefrigerantNotFoundException;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Kontroler obsługujący adresy /userpanel/searchrefrigerant
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class SearchRefrigerantController {
    private final RefrigerantService refrigerantService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param refrigerantService warstwa usług typu Refrigerant
     */
    public SearchRefrigerantController(RefrigerantService refrigerantService) {
        this.refrigerantService = refrigerantService;
    }

    /**
     * Metoda wyszukuje czynnik chłodniczy na podstawie przekazanej w formularzu frazy.
     *
     * @param search wyszukiwana fraza
     * @param model  model widoku
     * @return szablon widoku /searchrefrigerant
     */
    @GetMapping("/userpanel/searchrefrigerant")
    public String refrigerantSearchForm(@RequestParam(required = false) String search, Model model) {
        if(search != null) {
            model.addAttribute("searchquery", search);
            List<RefrigerantDto> refrigerantDtos = refrigerantService.findSpecificRefrigerants(search);
            model.addAttribute("refrigerants", refrigerantDtos);
            return "searchrefrigerant";
        }
        return "searchrefrigerant";
    }

    /**
     * Wyszukuje czynnik chłodniczy o wskazanym id.
     * Prezentuje szczegóły czynnika chłodniczego w widoku /viewrefrigerant.
     *
     * @param id    numer id
     * @param model model widoku
     * @return szablon widoku /viewrefrigerant
     */
    @GetMapping("/userpanel/refrigerant/{id}/view")
    public String viewRefrigerant(@PathVariable Long id, Model model) {
        RefrigerantDto refrigerantDto;
        try {
            refrigerantDto = refrigerantService.findRefrigerantById(id);
        } catch (RefrigerantNotFoundException e) {
            model.addAttribute("message", new Message("Błąd wyszukiwania", "Nie znaleziono czynnika o podanym ID."));
            return "message";
        }
        model.addAttribute("refrigerant", refrigerantDto);
        return "viewrefrigerant";
    }

    /**
     * Usuwa z bazy danych czynnik chłodniczy o wskazanym id.
     *
     * @param id    numer id
     * @param model model widoku
     * @return szablon widoku /message
     */
    @GetMapping("/userpanel/refrigerant/{id}/delete")
    public String deleteRefrigerant(@PathVariable Long id, Model model) {
        try {
            refrigerantService.deleteRefrigerantById(id);
        } catch (RefrigerantNotFoundException e) {
            model.addAttribute("message", new Message("Brak czynnika chłodniczego", "Nie znaleziono czynnika chłodniczego o wskazanym ID"));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Czynnik chłodniczy został pomyślnie usunięty z bazy"));
        return "message";
    }
}
