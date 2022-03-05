package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.category.CategoryService;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.producent.ProducentService;
import ls.hvacaretaker.refrigerant.Refrigerant;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddDeviceController {

    private CategoryService categoryService;
    private ProducentService producentService;
    private RefrigerantService refrigerantService;

    public AddDeviceController(CategoryService categoryService, ProducentService producentService, RefrigerantService refrigerantService) {
        this.categoryService = categoryService;
        this.producentService = producentService;
        this.refrigerantService = refrigerantService;
    }

    @GetMapping("/userpanel/adddevice")
    public String getAddDevice(Model model) {
        List<Category> categoryList = categoryService.getAllCategories();
        List<Producent> producentList = producentService.getAllProducents();
        List<Refrigerant> refrigerantList = refrigerantService.getAllRefrigerants();
        model.addAttribute("categories", categoryList);
        model.addAttribute("producents", producentList);
        model.addAttribute("refrigerants", refrigerantList);
        return "adddevice";
    }

}
