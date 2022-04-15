package ls.hvacaretaker.refrigerant;

import org.springframework.stereotype.Service;

/**
 * Klasa mapująca obiekty Refrigerant do DTO i na odwrót.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class RefrigerantMapper {

    /**
     * Mapuje encje typu Refrigerant do obiektów DTO.
     *
     * @param refrigerant obiekt typu Refrigerant
     * @return obiekty RefrigerantDto
     */
    public RefrigerantDto toDto(Refrigerant refrigerant) {
        RefrigerantDto refrigerantToDto = new RefrigerantDto();
        refrigerantToDto.setId(refrigerant.getId());
        refrigerantToDto.setName(refrigerant.getName());
        refrigerantToDto.setGWP(refrigerant.getGWP());
        refrigerantToDto.setDeviceList(refrigerant.getDevices());
        return refrigerantToDto;
    }

    /**
     * Mapuje obiekty RefrigerantDto do encji Refrigerant
     *
     * @param refrigerantDto obiekt RefrigerantDto
     * @return encja Refrigerant
     */
    public Refrigerant toEntity(RefrigerantDto refrigerantDto) {
        Refrigerant refrigerant = new Refrigerant();
        refrigerant.setId(refrigerantDto.getId());
        refrigerant.setName(refrigerantDto.getName());
        refrigerant.setGWP(refrigerantDto.getGWP());
        refrigerant.setDevices(refrigerantDto.getDeviceList());
        return refrigerant;
    }
}
