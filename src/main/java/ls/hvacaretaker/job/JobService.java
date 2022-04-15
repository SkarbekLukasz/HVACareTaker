package ls.hvacaretaker.job;

import ls.hvacaretaker.device.Device;
import ls.hvacaretaker.device.DeviceNotFoundException;
import ls.hvacaretaker.device.DeviceRepository;
import ls.hvacaretaker.security.CustomUserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Klasa warstwy usług typu Job
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    private final DeviceRepository deviceRepository;

    /**
     * Konstruktor klasy wstrzykujący poniższe zależności
     *
     * @param jobRepository    repozytorium typu Job
     * @param jobMapper        klasa mapująca typu Job
     * @param deviceRepository repozytorium typu Device
     */
    public JobService(JobRepository jobRepository, JobMapper jobMapper, DeviceRepository deviceRepository) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
        this.deviceRepository = deviceRepository;
    }

    /**
     * Zapisuje nowy obiekt typu Job w bazie danych
     *
     * @param id         numer id
     * @param user       Obiekt typu User, wykonujący czynność serwisową.
     * @param jobenddate Data wykonania czynności serwisowej
     * @param actionlog  Opis czynności serwisowej
     * @param actiontype Rodzaj czynności serwisowej
     * @throws DeviceNotFoundException nie odnaleziono urządzenia w bazie danych.
     */
    @Transactional
    public void saveJob(Long id, CustomUserDetails user, LocalDate jobenddate, String actionlog, JobType actiontype) throws DeviceNotFoundException {
        JobDto jobTosave = new JobDto();
        jobTosave.setAuthor(user.getFullName());
        Optional<Device> deviceToAdd = deviceRepository.findById(id);
        jobTosave.setDevice(deviceToAdd.orElseThrow(DeviceNotFoundException::new));
        jobTosave.setJobAddTime(LocalDate.now());
        jobTosave.setJobDescription(actionlog);
        jobTosave.setJobType(actiontype);
        jobTosave.setJobEndTime(jobenddate);
        Job entityTosave = jobMapper.toEntity(jobTosave);
        Job jobSaved = jobRepository.save(entityTosave);
        jobSaved.getDevice().addJob(jobSaved);
    }
}
