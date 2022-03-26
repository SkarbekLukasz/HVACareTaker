package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.category.CategoryNotFoundException;
import ls.hvacaretaker.category.CategoryService;
import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.device.DeviceAlreadyExistException;
import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceService;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.producent.ProducentNotFoundException;
import ls.hvacaretaker.producent.ProducentRepository;
import ls.hvacaretaker.producent.ProducentService;
import ls.hvacaretaker.refrigerant.Refrigerant;
import ls.hvacaretaker.refrigerant.RefrigerantNotFoundException;
import ls.hvacaretaker.refrigerant.RefrigerantService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @PostMapping("/userpanel/adddevice/message")
    public String saveNewDevice(@RequestParam String devicename,
                                @RequestParam String serialnumber,
                                @RequestParam String devicemodel,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
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
        try {
            deviceDto.setProducent(producentService.getProducentEntity(producent));
        } catch (ProducentNotFoundException e) {
            model.addAttribute("message", new Message("message", "Brak producenta o wskazanym id w bazie danych"));
            return "message";
        }
        deviceDto.setValue(cost);
        deviceDto.setCoolingPower(load);
        if(refrigerant != null) {
            try{
                deviceDto.setRefrigerant(refrigerantService.getRefrigerantEntity(refrigerant));
            } catch (RefrigerantNotFoundException e) {
                model.addAttribute("message", new Message("message","Brak czynnika chłodniczego o wskazanym id w bazie danych"));
                return "message";
            }
        }
        else {
            deviceDto.setRefrigerant(null);
        }
        deviceDto.setRefrigerantMass(mass);
        deviceDto.setLocalization(localization);
        Long categoryId = Long.parseLong((String) session.getAttribute("categoryid"));
        try {
            deviceDto.setCategory(categoryService.getCategoryEntity(categoryId));
        } catch (CategoryNotFoundException e) {
            model.addAttribute("message", new Message("404 Not found", "Brak kategorii o wskazanym id w bazie danych."));
            return "message";
        }
        deviceDto.setJobList(new ArrayList<>());
        deviceDto.setLastHermeticControl(LocalDate.now());
        try {
            deviceService.saveDevice(deviceDto);
        } catch (DeviceAlreadyExistException e) {
            model.addAttribute("message", new Message("405 Bad request", "Urządzenie o podanym numerze seryjnym już istnieje w bazie danych"));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Pomyślnie dodano nowe urządzenie do bazy"));
        return "message";
    }

}
