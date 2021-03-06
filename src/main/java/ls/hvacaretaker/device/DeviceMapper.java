package ls.hvacaretaker.device;

import org.springframework.stereotype.Service;

/**
 * Klasa mapująca encje do obiektów DTO i na odwrót.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class DeviceMapper {

    /**
     * Metoda zamieniająca obiekt encji do obiektu DTO
     *
     * @param device obiekt typu Device
     * @return obiektu typu DTO
     */
    public DeviceDto toDto(Device device) {
        DeviceDto deviceToDto = new DeviceDto();
        deviceToDto.setId(device.getId());
        deviceToDto.setName(device.getName());
        deviceToDto.setSerialNumber(device.getSerialNumber());
        deviceToDto.setModel(device.getModel());
        deviceToDto.setValue(device.getValue());
        deviceToDto.setLocalization(device.getLocalization());
        deviceToDto.setProductionDate(device.getProductionDate());
        deviceToDto.setProducent(device.getProducent());
        deviceToDto.setCategory(device.getCategory());
        deviceToDto.setRefrigerant(device.getRefrigerant());
        deviceToDto.setCoolingPower(device.getCoolingPower());
        deviceToDto.setRefrigerantMass(device.getRefrigerantMass());
        deviceToDto.setJobList(device.getJobList());
        deviceToDto.setLastHermeticControl(device.getLastHermeticControl());
        deviceToDto.setNextHermeticControl(device.getNextHermeticControl());
        return deviceToDto;
    }

    /**
     * Zamienia obiekt typu DeviceDto na obiekt encji.
     *
     * @param deviceDto obiekt typu DeviceDto
     * @return encja obiektu Device
     */
    public Device toEntity(DeviceDto deviceDto) {
        Device entity = new Device();
        entity.setId(deviceDto.getId());
        entity.setName(deviceDto.getName());
        entity.setSerialNumber(deviceDto.getSerialNumber());
        entity.setModel(deviceDto.getModel());
        entity.setValue(deviceDto.getValue());
        entity.setLocalization(deviceDto.getLocalization());
        entity.setProductionDate(deviceDto.getProductionDate());
        entity.setProducent(deviceDto.getProducent());
        entity.setCategory(deviceDto.getCategory());
        entity.setRefrigerant(deviceDto.getRefrigerant());
        entity.setCoolingPower(deviceDto.getCoolingPower());
        entity.setRefrigerantMass(deviceDto.getRefrigerantMass());
        entity.setNextHermeticControl(deviceDto.getNextHermeticControl());
        entity.setLastHermeticControl(deviceDto.getLastHermeticControl());
        entity.setJobList(deviceDto.getJobList());
        return entity;
    }
}
