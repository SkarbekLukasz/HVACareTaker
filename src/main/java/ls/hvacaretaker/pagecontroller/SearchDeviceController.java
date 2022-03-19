package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceNotFoundException;
import ls.hvacaretaker.device.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchDeviceController {

    private final DeviceService deviceService;

    public SearchDeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/userpanel/searchdevice")
    public String getSearchDevice(@RequestParam(required = false) String search, Model model) {
        if(search != null) {
            model.addAttribute("searchquery", search);
            List<DeviceDto> deviceDtoList = deviceService.findSpecificDevices(search);
            model.addAttribute("devicesList", deviceDtoList);
        }
        return "searchdevice";
    }

    @GetMapping("/userpanel/device/{id}/view")
    public String viewDevice(@PathVariable Long id, Model model) {
        DeviceDto deviceFound;
        try {
            deviceFound = deviceService.findSpecificDeviceById(id);
        } catch (DeviceNotFoundException e) {
            model.addAttribute("message", new Message("Brak urządzenia", "Nie znaleziono urządzenia o wskazanym ID"));
            return "message";
        }
        model.addAttribute("device", deviceFound);
        return "viewdevice";
    }

    @GetMapping("/userpanel/device/{id}/delete")
    public String deleteDevice(@PathVariable Long id, Model model) {
        try {
            deviceService.deleteSpecificDevice(id);
        } catch (DeviceNotFoundException e) {
            model.addAttribute("message", new Message("Brak urządzenia", "Nie znaleziono urządzenia o wskazanym ID"));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Urządzenie zostało pomyślnie usunięte z bazy."));
        return "message";
    }
}
