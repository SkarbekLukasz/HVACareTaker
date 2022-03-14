package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.producent.ProducentDto;
import ls.hvacaretaker.producent.ProducentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchProducentController {

    private final ProducentService producentService;

    public SearchProducentController(ProducentService producentService) {
        this.producentService = producentService;
    }

    @GetMapping("/userpanel/searchproducent")
    public String getSearchProducent(@RequestParam(required = false) String search, Model model) {
        if(search != null) {
            model.addAttribute("searchquery", search);
            List<ProducentDto> producentDtos = producentService.findSpecificProducent(search);
            model.addAttribute("producents", producentDtos);
            return "searchproducent";
        }
        return "searchproducent";
    }
}
