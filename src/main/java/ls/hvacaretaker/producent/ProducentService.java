package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Klasa warstwy usług typu Producent
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProducentService {

    private final ProducentRepository producentRepository;
    private final ProducentMapper producentMapper;

    /**
     * Konstruktor wstrzykujący poniższe zależności:
     *
     * @param producentRepository repozytorium obiektów Producent
     * @param producentMapper     klasa mapująca obiekty Producent
     */
    public ProducentService(ProducentRepository producentRepository, ProducentMapper producentMapper) {
        this.producentRepository = producentRepository;
        this.producentMapper = producentMapper;
    }

    /**
     * Znajduje i zwraca listę wszystkich producentów w bazie danych.
     *
     * @return lista wszystkich producentów
     */
    public List<Producent> getAllProducents() {
        return producentRepository.findAll();
    }

    /**
     * Znajduje producenta o wskazanym id w bazie danych.
     *
     * @param id numer id
     * @return producent o wskazanym id
     * @throws ProducentNotFoundException wyjątek rzucany, gdy producent o wskazanym id nie zostanie znaleziony
     */
    public Producent getProducentEntity(Long id) throws ProducentNotFoundException {
        Optional<Producent> producentFound = producentRepository.findById(id);
        return producentFound.orElseThrow(ProducentNotFoundException::new);
    }

    /**
     * Zapisuje nowego producenta do bazy danych przy użyciu informacji przekazanych w parametrach.
     *
     * @param name        nazwa producenta
     * @param contactInfo dane kontaktowe producenta
     * @throws ProducentAlreadyExistException rzucany, gdy zapisywany obiekt już znajduje się w bazie danych.
     */
    @Transactional
    public void save(String name, String contactInfo) throws ProducentAlreadyExistException {
        Optional<Producent> producentSearch = producentRepository.findByNameIgnoreCase(name);
        if(producentSearch.isPresent()) {
            throw new ProducentAlreadyExistException();
        }
        ProducentDto producentDto = new ProducentDto();
        producentDto.setName(name);
        producentDto.setContactInfo(contactInfo);
        List<Device> deviceList = new ArrayList<>();
        producentDto.setDeviceList(deviceList);
        Producent producentToSave = producentMapper.toEntity(producentDto);
        producentRepository.save(producentToSave);
    }

    /**
     * Znajduje producentów o nazwie przekazanej w parametrze.
     *
     * @param name nazwa producenta
     * @return lista odnalezionych producentów
     */
    public List<ProducentDto> findSpecificProducents(String name) {
        return producentRepository.findByNameContainingIgnoreCase(name).stream()
                .map(producentMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Znajduje producenta o wskazanym id
     *
     * @param id numer id
     * @return obiekt ProducentDto szukanego producenta
     */
    public ProducentDto findProducentByid(Long id) {
        return producentRepository.findById(id)
                .map(producentMapper::toDto)
                .orElseThrow(ProducentNotFoundException::new);
    }

    /**
     * Usuwa producenta o wskazanym id z bazy danych.
     *
     * @param id numer id
     * @throws ProducentNotFoundException rzucany, gdy wyszukiwany producent nie zostanie odnaleziony w bazie danych.
     */
    @Transactional
    public void deleteSpecificProducent(Long id) throws ProducentNotFoundException {
        Optional<Producent> producentSearch = producentRepository.findById(id);
        producentRepository.delete(producentSearch.orElseThrow(ProducentNotFoundException::new));
    }
}
