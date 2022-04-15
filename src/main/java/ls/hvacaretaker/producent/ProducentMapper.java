package ls.hvacaretaker.producent;

import org.springframework.stereotype.Service;

/**
 * Klasa mapująca obiekty Producent do obiektów DTo i na odwrót.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProducentMapper {

    /**
     * Mapuje obiekt Producent do obiektu DTO.
     *
     * @param producent obiekt Producent
     * @return obiekt ProducentDto
     */
    public ProducentDto toDto(Producent producent) {
        ProducentDto producentToDto = new ProducentDto();
        producentToDto.setId(producent.getId());
        producentToDto.setName(producent.getName());
        producentToDto.setContactInfo(producent.getContactInfo());
        producentToDto.setDeviceList(producent.getDevices());
        return producentToDto;
    }

    /**
     * Mapuje obiekt ProducentDTO do encji.
     *
     * @param producentDto obiekt ProducentDto
     * @return obiekt encji Producent
     */
    public Producent toEntity(ProducentDto producentDto) {
        Producent entity = new Producent();
        entity.setName(producentDto.getName());
        entity.setDevices(producentDto.getDeviceList());
        entity.setContactInfo(producentDto.getContactInfo());
        return entity;
    }
}
