package ls.hvacaretaker.commonlogic;

import ls.hvacaretaker.device.Device;
import ls.hvacaretaker.device.DeviceRepository;
import ls.hvacaretaker.user.User;
import ls.hvacaretaker.user.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za sprawdzanie terminów kontroli szczelności.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Component
public class HermeticTestCheck {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final int DAY_TIME = 86400000;

    /**
     * Konstruktor klasy, wstrzykujący poniższe zależności.
     *
     * @param deviceRepository repozytorium obiektów typu Device
     * @param userRepository   repozytorium obiektów typu User
     * @param emailService     klasa usług wysyłki maili
     */
    public HermeticTestCheck(DeviceRepository deviceRepository, UserRepository userRepository, EmailService emailService) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }


    /**
     * Wyszykuje w bazie danych kontrole szczelności, dla których termin wykonania jest krótszy, niż 2 tygodnie.
     *
     * @return lista obiektów typu Device, dla których termin kontroli szczelności jest krótszy, niż 2 tygodnie.
     */
    public List<Device> findIncomingTests() {
        return deviceRepository.findAll().stream()
                .filter(device -> device.getNextHermeticControl() != null)
                .filter(device -> (device.getNextHermeticControl().minusWeeks(2)).isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    /**
     * Raz w ciągu 24 godzin metoda sprawdza, czy są kontrole szczelności o terminie odległym równo 2 tygodnie od daty sprawdzenia.
     * Dla znalezionych pozycji wysyłane są maile przypominające do wszystkich użytkowników z bazy danych.
     * Metoda rekurencyjna.
     * @throws InterruptedException wyjątek występujący w momencie przerwania pracy wątku.
     */
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
