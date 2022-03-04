package ls.hvacaretaker.producent;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducentService {

    private ProducentRepository producentRepository;

    public ProducentService(ProducentRepository producentRepository) {
        this.producentRepository = producentRepository;
    }

    public List<Producent> getAllProducents() {
        List<Producent> producentList = producentRepository.findAll();
        return producentList;
    }
}
