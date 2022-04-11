package ls.hvacaretaker.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repozytorium dla obiektów typu Device.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAll();

    /**
     * Wyszukuje obiekt Device na podstawie numeru seryjnego urządzenia.
     *
     * @param serial numer seryjny urządzenia
     * @return Optional typu Device
     */
    Optional<Device> findBySerialNumberIgnoreCase(String serial);

    /**
     * Wyszukuje wszystkie urządzenia, których nazwa lub numer seryjny zawierają ciągi znaków przekazane w parametrach.
     *
     * @param name  nazwa urządzenia
     * @param name2 numer seryjny urządzenia
     * @return lista typu Device
     */
    List<Device> findAllByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(String name, String name2);
    Optional<Device> findById(Long id);
}
