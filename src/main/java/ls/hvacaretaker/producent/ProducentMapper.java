package ls.hvacaretaker.producent;

import org.springframework.stereotype.Service;

@Service
public class ProducentMapper {

    public ProducentDto toDto(Producent producent) {
        ProducentDto producentToDto = new ProducentDto();
        producentToDto.setId(producent.getId());
        producentToDto.setName(producent.getName());
        return producentToDto;
    }
}
