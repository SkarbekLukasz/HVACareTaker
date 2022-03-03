package ls.hvacaretaker.refrigerant;

import org.springframework.stereotype.Service;

@Service
public class RefrigerantMapper {

    public RefrigerantDto toDto(Refrigerant refrigerant) {
        RefrigerantDto refrigerantToDto = new RefrigerantDto();
        refrigerantToDto.setId(refrigerant.getId());
        refrigerantToDto.setName(refrigerant.getName());
        return refrigerantToDto;
    }
}
