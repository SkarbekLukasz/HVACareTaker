package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RefrigerantService {

    private final RefrigerantRepository refrigerantRepository;
    private final RefrigerantMapper refrigerantMapper;

    public RefrigerantService(RefrigerantRepository refrigerantRepository, RefrigerantMapper refrigerantMapper) {
        this.refrigerantRepository = refrigerantRepository;
        this.refrigerantMapper = refrigerantMapper;
    }

    public List<Refrigerant> getAllRefrigerants() {
        return refrigerantRepository.findAll();
    }

    public Refrigerant getRefrigerantEntity(Long id) throws  RefrigerantNotFoundException {
        Optional<Refrigerant> refrigerantFound = refrigerantRepository.findById(id);
        return refrigerantFound.orElseThrow(RefrigerantNotFoundException::new);
    }

    @Transactional
    public void saveNewRefrigerant(String name, int gwp) throws RefrigerantAlreadyExistException{
        Optional<Refrigerant> refrigerantToFind = refrigerantRepository.findByNameIgnoreCase(name);
        if(refrigerantToFind.isPresent()) {
            throw new RefrigerantAlreadyExistException();
        }
        RefrigerantDto refrigerantToSave = new RefrigerantDto();
        refrigerantToSave.setName(name);
        refrigerantToSave.setGWP(gwp);
        List<Device> deviceList = new ArrayList<>();
        refrigerantToSave.setDeviceList(deviceList);
        Refrigerant refrigerant = refrigerantMapper.toEntity(refrigerantToSave);
        refrigerantRepository.save(refrigerant);
    }
}
