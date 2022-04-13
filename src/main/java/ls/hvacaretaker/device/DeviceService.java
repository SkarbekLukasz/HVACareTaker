package ls.hvacaretaker.device;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Klasa warstwy usług typu Device
 */
@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    /**
     * Konstruktor klasy wstrzykujący poniższe komponenty.
     *
     * @param deviceRepository repozytorium typu Device
     * @param deviceMapper     klasa mapująca typu Device
     */
    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    /**
     * Zapisuje nowy obiekt typu Device do bazy danych.
     *
     * @param deviceDto obiekt typu DeviceDto odebrany z kontrolera.
     * @throws DeviceAlreadyExistException wyjątek urządzenia istniejącego już w bazie danych.
     */
    @Transactional
    public void saveDevice(DeviceDto deviceDto) throws DeviceAlreadyExistException {
        Device deviceToSave = deviceMapper.toEntity(deviceDto);
        Optional<Device> deviceCheck = deviceRepository.findBySerialNumberIgnoreCase(deviceToSave.getSerialNumber());
        if(deviceCheck.isPresent()) {
            throw new DeviceAlreadyExistException();
        }
        Device deviceSaved = deviceRepository.save(deviceToSave);
        deviceSaved.getCategory().addDevice(deviceSaved);
        deviceSaved.getProducent().addDevice(deviceSaved);
        if(deviceSaved.getRefrigerant() != null) {
            deviceSaved.getRefrigerant().addDevice(deviceSaved);
        }
    }

    /**
     * Wyszukuje urządzenia, których nazwa jest zgodna z przekazanym parametrem.
     *
     * @param name nazwa urządzenia
     * @return lista urządzeń typu Device
     */
    public List<DeviceDto> findSpecificDevices(String name) {
        List<Device> entityList = deviceRepository.findAllByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name, name);
        return entityList.stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Wyszukuje urządzenia o wskazanym w parametrze id.
     *
     * @param id
     * @return obiekt typu DeviceDto
     * @throws DeviceNotFoundException the device not found exception
     */
    public DeviceDto findSpecificDeviceById(Long id) throws DeviceNotFoundException {
        Optional<Device> deviceById = deviceRepository.findById(id);
        return deviceMapper.toDto(deviceById.orElseThrow(DeviceNotFoundException::new));
    }

    /**
     * Usuwa urządzenie o wskazanym id z bazy danych.
     *
     * @param id
     * @throws DeviceNotFoundException wyjątek w przypadku nie odnalezienia urządzenia w bazie danych.
     */
    @Transactional
    public void deleteSpecificDevice(Long id) throws DeviceNotFoundException {
        Optional<Device> deviceById = deviceRepository.findById(id);
        deviceRepository.delete(deviceById.orElseThrow(DeviceNotFoundException::new));
    }

    /**
     * Wyszukuje w bazie danych wszystkie urządzenia
     *
     * @return lista urządzeń DeviceDto
     */
    public List<DeviceDto> findAllDevices() {
        return deviceRepository.findAll().stream()
                .map(deviceMapper::toDto)
                .collect(Collectors.toList());
    }
}
