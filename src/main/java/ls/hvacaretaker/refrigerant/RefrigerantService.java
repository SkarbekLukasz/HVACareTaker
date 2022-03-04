package ls.hvacaretaker.refrigerant;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefrigerantService {

    private RefrigerantRepository refrigerantRepository;

    public RefrigerantService(RefrigerantRepository refrigerantRepository) {
        this.refrigerantRepository = refrigerantRepository;
    }

    public List<Refrigerant> getAllRefrigerants() {
        List<Refrigerant> refrigerantList = refrigerantRepository.findAll();
        return refrigerantList;
    }
}
