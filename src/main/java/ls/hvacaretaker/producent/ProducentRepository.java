package ls.hvacaretaker.producent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repozytorium obiektów Producent
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface ProducentRepository extends JpaRepository<Producent, Long> {
    List<Producent> findAll();

    /**
     * Wyszykuje producenta na podstawie przekazanego parametru name
     *
     * @param name nazwa producenta
     * @return optional obiektu Producent
     */
    Optional<Producent> findByNameIgnoreCase(String name);

    /**
     * Wyszukuje listę producentów, których nazwa zawiera przekazany w parametrze String.
     *
     * @param name nazwa producenta
     * @return lista obiektów Producent
     */
    List<Producent> findByNameContainingIgnoreCase(String name);
}
