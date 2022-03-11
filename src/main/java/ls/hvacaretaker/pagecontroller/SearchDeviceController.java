package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


}
