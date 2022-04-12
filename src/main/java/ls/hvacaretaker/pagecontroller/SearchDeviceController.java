package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceNotFoundException;
import ls.hvacaretaker.device.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Kontroler obsługujący adresy /userpanel/searchdevice
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class SearchDeviceController {

    private final DeviceService deviceService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param deviceService Warstwa usług type Device
     */
    public SearchDeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * Wyszukuje i przesyła do modelu widoku listę wskazanych urządzeń.
     * Zwraca szablon widoku /searchdevice
     *
     * @param search wyszukiwana fraza
     * @param model  model widoku
     * @return szablon widoku /searchdevice
     */
    @GetMapping("/userpanel/searchdevice")
    public String getSearchDevice(@RequestParam(required = false) String search, Model model) {
        if(search != null) {
            model.addAttribute("searchquery", search);
            List<DeviceDto> deviceDtoList = deviceService.findSpecificDevices(search);
            model.addAttribute("devicesList", deviceDtoList);
        }
        return "searchdevice";
    }

    /**
     * Wyświetla szczegółowe dane na temat urządzenia o wskazanym id.
     *
     * @param id    id urządzenia
     * @param model model widoku
     * @return szablon widoku /viewdevice
     */
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

    /**
     * Metoda pozwala na usunięcie urządzenia o wskazanym id z bazy danych.
     *
     * @param id    id urządzenia
     * @param model model widoku
     * @return szablon widoku /message
     */
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
