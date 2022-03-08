package ls.hvacaretaker.device;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    public DeviceService(DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

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
}
