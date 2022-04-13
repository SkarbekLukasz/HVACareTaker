package ls.hvacaretaker.pagecontroller;

import ls.hvacaretaker.common.Message;
import ls.hvacaretaker.device.DeviceDto;
import ls.hvacaretaker.device.DeviceNotFoundException;
import ls.hvacaretaker.device.DeviceService;
import ls.hvacaretaker.job.JobService;
import ls.hvacaretaker.job.JobType;
import ls.hvacaretaker.security.CustomUserDetails;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


/**
 * Kontroler obsługujący adresy /servicepanel
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ServicePanelController {
    private final DeviceService deviceService;
    private final JobService jobService;

    /**
     * Konstruktor wstrzyykujący zależności
     *
     * @param deviceService warstwa usług typu Device
     * @param jobService    warstwa usług typu Job
     */
    public ServicePanelController(DeviceService deviceService, JobService jobService) {
        this.deviceService = deviceService;
        this.jobService = jobService;
    }

    /**
     * Metoda wyświetla formularz dodawania nowej czynności serwisowej.
     *
     * @param id              numer id
     * @param model           model widoku
     * @param securityContext kontekst bezpieczeństwa
     * @return szablon widoku /servicepanel
     */
    @GetMapping("/servicepanel/device/{id}/addjob")
    public String loadServicePanel(@PathVariable Long id, Model model, @CurrentSecurityContext SecurityContext securityContext) {
        DeviceDto deviceFound;
        try {
            deviceFound = deviceService.findSpecificDeviceById(id);
        } catch (DeviceNotFoundException e) {
            model.addAttribute("message", new Message("Brak urządzenia", "Nie znaleziono urządzenia o wskazanym ID"));
            return "message";
        }
        CustomUserDetails user = (CustomUserDetails) securityContext.getAuthentication().getPrincipal();
        model.addAttribute("detail", user);
        model.addAttribute("device", deviceFound);
        return "servicepanel";
    }

    /**
     * Metoda dodaje do bazy danych czynność serwisową do urządzenia o wskazanym id.
     *
     * @param id              numer id
     * @param model           model widoku
     * @param securityContext kontekst bezpieczeństwa
     * @param jobenddate      data dodania czynności serwisowej
     * @param actiontype      typ czynności serwisowej
     * @param actionlog       opis czynności serwisowej
     * @return szablon widoku /message
     */
    @PostMapping("/servicepanel/device/{id}/addjob/success")
    public String addServiceJob(@PathVariable Long id,
                                Model model,
                                @CurrentSecurityContext SecurityContext securityContext,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate jobenddate,
                                @RequestParam JobType actiontype,
                                @RequestParam String actionlog) {
        CustomUserDetails user = (CustomUserDetails) securityContext.getAuthentication().getPrincipal();
        try{
            jobService.saveJob(id, user, jobenddate, actionlog, actiontype);
        } catch (DeviceNotFoundException e) {
            model.addAttribute("message", new Message("404 Not Found", "Brak urządzenia o wskazanym id w bazie danych."));
            return "message";
        }
        model.addAttribute("message", new Message("Sukces!", "Pomyślnie dodano czynnośc serwisową do bazy danych."));
        return "message";
    }
}
