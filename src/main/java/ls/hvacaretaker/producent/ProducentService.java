package ls.hvacaretaker.producent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
