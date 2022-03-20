package ls.hvacaretaker.refrigerant;

import org.springframework.stereotype.Service;

@Service
public class RefrigerantMapper {

    public RefrigerantDto toDto(Refrigerant refrigerant) {
        RefrigerantDto refrigerantToDto = new RefrigerantDto();
        refrigerantToDto.setId(refrigerant.getId());
        refrigerantToDto.setName(refrigerant.getName());
        refrigerantToDto.setGWP(refrigerant.getGWP());
        refrigerantToDto.setDeviceList(refrigerant.getDevices());
        return refrigerantToDto;
    }

    public Refrigerant toEntity(RefrigerantDto refrigerantDto) {
        Refrigerant refrigerant = new Refrigerant();
        refrigerant.setId(refrigerantDto.getId());
        refrigerant.setName(refrigerantDto.getName());
        refrigerant.setGWP(refrigerantDto.getGWP());
        refrigerant.setDevices(refrigerantDto.getDeviceList());
        return refrigerant;
    }
}
