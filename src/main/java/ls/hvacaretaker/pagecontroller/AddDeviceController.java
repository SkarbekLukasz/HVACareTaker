package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.category.CategoryService;
import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceService;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.producent.ProducentRepository;
import ls.hvacaretaker.producent.ProducentService;
import ls.hvacaretaker.refrigerant.Refrigerant;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class AddDeviceController {

    private final CategoryService categoryService;
    private final ProducentService producentService;
    private final RefrigerantService refrigerantService;
    private final DeviceService deviceService;


    public AddDeviceController(CategoryService categoryService, ProducentService producentService, RefrigerantService refrigerantService, ProducentRepository producentRepository, DeviceService deviceService) {
        this.categoryService = categoryService;
        this.producentService = producentService;
        this.refrigerantService = refrigerantService;
        this.deviceService = deviceService;
    }

    @GetMapping("/userpanel/adddevice")
    public String getAddDevice(@RequestParam(required = false) String categoryid, @RequestParam(required = false) String categoryname, Model model, HttpSession session) {
        List<Category> categoryList = categoryService.getAllCategories();
        List<Producent> producentList = producentService.getAllProducents();
        List<Refrigerant> refrigerantList = refrigerantService.getAllRefrigerants();
        if(categoryid != null) {
            session.setAttribute("categoryid", categoryid);
        }
        if(categoryname != null) {
            session.setAttribute("categoryname", categoryname);
        }
        model.addAttribute("categories", categoryList);
        model.addAttribute("producents", producentList);
        model.addAttribute("refrigerants", refrigerantList);
        return "adddevice";
    }

    @PostMapping("/userpanel/adddevice/success")
    public String saveNewDevice(@RequestParam String devicename,
                                @RequestParam String serialnumber,
                                @RequestParam String devicemodel,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                @RequestParam Long producent,
                                @RequestParam Double cost,
                                @RequestParam(required = false) Double load,
                                @RequestParam(required = false) Long refrigerant,
                                @RequestParam(required = false) Double mass,
                                @RequestParam String localization,
                                Model model,
                                HttpSession session) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setName(devicename);
        deviceDto.setSerialNumber(serialnumber);
        deviceDto.setModel(devicemodel);
        deviceDto.setProductionDate(date);
        deviceDto.setProducent(producentService.getProducentEntity(producent));
        deviceDto.setValue(cost);
        deviceDto.setCoolingPower(load);
        if(refrigerant != null) {
            deviceDto.setRefrigerant(refrigerantService.getRefrigerantEntity(refrigerant));
        }
        else {
            deviceDto.setRefrigerant(null);
        }
        deviceDto.setRefrigerantMass(mass);
        deviceDto.setLocalization(localization);
        Long categoryId = Long.parseLong((String) session.getAttribute("categoryid"));
        deviceDto.setCategory(categoryService.getCategoryEntity(categoryId));
        deviceService.saveDevice(deviceDto);
        return "success";
    }

}
