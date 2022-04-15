package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Warstwa usług typu Refrigerant
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class RefrigerantService {

    private final RefrigerantRepository refrigerantRepository;
    private final RefrigerantMapper refrigerantMapper;

    /**
     * Konstruktor wstrzykujący zależności
     *
     * @param refrigerantRepository repozytorium obiektów Refrigerant
     * @param refrigerantMapper     klasa mapująca obiektów Refrigerant
     */
    public RefrigerantService(RefrigerantRepository refrigerantRepository, RefrigerantMapper refrigerantMapper) {
        this.refrigerantRepository = refrigerantRepository;
        this.refrigerantMapper = refrigerantMapper;
    }

    /**
     * Zwraca listę wszystkich obiektów Refrigerant z bazy danych
     *
     * @return lista obiektów Refrigerant
     */
    public List<Refrigerant> getAllRefrigerants() {
        return refrigerantRepository.findAll();
    }

    /**
     * Wyszukuje obiekt Refrigerant o wskazanym w parametrze numerze id.
     *
     * @param id numer id
     * @return obiekt typu Refrigerant
     * @throws RefrigerantNotFoundException rzucany, gdy wyszukiwany obiekt Refrigerant nie zostanie odnaleziony
     */
    public Refrigerant getRefrigerantEntity(Long id) throws  RefrigerantNotFoundException {
        Optional<Refrigerant> refrigerantFound = refrigerantRepository.findById(id);
        return refrigerantFound.orElseThrow(RefrigerantNotFoundException::new);
    }

    /**
     * Zapisuje do bazy danych nowy obiekt typu Refrigerant
     *
     * @param name nazwa czynnika chłodniczego
     * @param gwp  gwp czynnika chłodniczego
     * @throws RefrigerantAlreadyExistException rzucany, gdy zapisywany obiekt Refrigerant już znajduje się w bazie danych.
     */
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


    /**
     * Wyszukuje wszystkie czynniki chłodnicze o nazwie wskazanej w parametrze.
     *
     * @param search nazwa wyszukiwanych czynników chłodniczych
     * @return lista czynników chłodniczych
     */
    public List<RefrigerantDto> findSpecificRefrigerants(String search) {
        return refrigerantRepository.findAllByNameContainingIgnoreCase(search).stream()
                .map(refrigerantMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Wyszukuje czynnik chłodniczy o wskazanym w parametrze numerze id
     *
     * @param id numer id
     * @return obiekt DTO typu Refrigerant
     */
    public RefrigerantDto findRefrigerantById(Long id) {
        return refrigerantMapper.toDto(refrigerantRepository.findById(id).orElseThrow(RefrigerantNotFoundException::new));
    }

    /**
     * Usuwa z bazy danych czynnik chłodniczy o wskazanym w parametrze numerze id
     *
     * @param id numer id
     * @throws RefrigerantNotFoundException wyjątek rzucany, gdy wyszukiwany czynnik chłodniczy nie zostanie odnaleziony.
     */
    @Transactional
    public void deleteRefrigerantById(Long id) throws RefrigerantNotFoundException {
        Optional<Refrigerant> refrigerantToDelete = refrigerantRepository.findById(id);
        refrigerantRepository.delete(refrigerantToDelete.orElseThrow(RefrigerantNotFoundException::new));
    }
}
