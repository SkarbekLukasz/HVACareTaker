package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProducentService {

    private final ProducentRepository producentRepository;
    private final ProducentMapper producentMapper;

    public ProducentService(ProducentRepository producentRepository, ProducentMapper producentMapper) {
        this.producentRepository = producentRepository;
        this.producentMapper = producentMapper;
    }

    public List<Producent> getAllProducents() {
        return producentRepository.findAll();
    }

    public Producent getProducentEntity(Long id) throws ProducentNotFoundException {
        Optional<Producent> producentFound = producentRepository.findById(id);
        return producentFound.orElseThrow(ProducentNotFoundException::new);
    }

    @Transactional
    public void save(String name) throws ProducentAlreadyExistException {
        Optional<Producent> producentSearch = producentRepository.findByNameIgnoreCase(name);
        if(producentSearch.isPresent()) {
            throw new ProducentAlreadyExistException();
        }
        ProducentDto producentDto = new ProducentDto();
        producentDto.setName(name);
        List<Device> deviceList = new ArrayList<>();
        producentDto.setDeviceList(deviceList);
        Producent producentToSave = producentMapper.toEntity(producentDto);
        producentRepository.save(producentToSave);
    }

    public List<ProducentDto> findSpecificProducent(String name) {
        return producentRepository.findByNameContainingIgnoreCase(name).stream()
                .map(producentMapper::toDto)
                .collect(Collectors.toList());
    }
}
