package ls.hvacaretaker.commonlogic;

import ls.hvacaretaker.device.Device;
import ls.hvacaretaker.device.DeviceRepository;
import ls.hvacaretaker.user.User;
import ls.hvacaretaker.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HermeticTestCheck {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final int DAY_TIME = 86400000;

    public HermeticTestCheck(DeviceRepository deviceRepository, UserRepository userRepository, EmailService emailService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }


    public List<Device> findIncomingTests() {
        return deviceRepository.findAll().stream()
                .filter(device -> device.getNextHermeticControl() != null)
                .filter(device -> (device.getNextHermeticControl().minusWeeks(2)).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Async
    public void hermeticTestReminder() throws InterruptedException{
        List<Device> incomingHermeticTests = deviceRepository.findAll().stream()
                .filter(device -> device.getNextHermeticControl() != null)
                .filter(device -> device.getNextHermeticControl().minusWeeks(2).isEqual(LocalDate.now())).toList();
        List<User> allUsers = userRepository.findAll();
        for(Device device : incomingHermeticTests) {
            for(User user : allUsers) {
                String email = user.getEmail();
                String topic = "Kontrola szczelności " + device.getName();
                String body = "W dniu " + device.getNextHermeticControl() + " mija termin wykonania kolejnej kontroli szczelności dla urządzenia " + device.getName() + ", o numerze seryjnym " + device.getSerialNumber();
                emailService.sendMail(email, topic, body);
            }
        }
        Thread.sleep(DAY_TIME);
        hermeticTestReminder();
    }
}
