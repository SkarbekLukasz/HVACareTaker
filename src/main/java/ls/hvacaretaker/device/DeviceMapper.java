package ls.hvacaretaker.device;

import org.springframework.stereotype.Service;

@Service
public class DeviceMapper {

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
        return deviceToDto;
    }

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
        return entity;
    }
}
