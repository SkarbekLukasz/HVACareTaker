package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.producent.ProducentNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@Service
public class RefrigerantService {

    private final RefrigerantRepository refrigerantRepository;

    public RefrigerantService(RefrigerantRepository refrigerantRepository) {
        this.refrigerantRepository = refrigerantRepository;
    }

    public List<Refrigerant> getAllRefrigerants() {
        return refrigerantRepository.findAll();
    }

    public Refrigerant getRefrigerantEntity(Long id) {
        Optional<Refrigerant> refrigerantFound = refrigerantRepository.findById(id);
        return refrigerantFound.orElseThrow(RefrigerantNotFoundException::new);
    }
}
