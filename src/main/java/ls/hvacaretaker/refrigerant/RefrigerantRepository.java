package ls.hvacaretaker.refrigerant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repozytorium obiektów Refrigerant
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface RefrigerantRepository extends JpaRepository<Refrigerant, Long> {
    List<Refrigerant> findAll();

    /**
     * Zwraca optional obiektu Refrigerant o nazwie wskazanej w parametrze.
     *
     * @param name nazwa czynnika chłodniczego
     * @return optional obiektu Refrigerant
     */
    Optional<Refrigerant> findByNameIgnoreCase(String name);

    /**
     * Zwraca listę wszystkich obiektów Refrigerant o nazwie wskazanej w parametrze.
     *
     * @param name nazwa czynnika chłodniczeog
     * @return lista obiektów Refrigerant
     */
    List<Refrigerant> findAllByNameContainingIgnoreCase(String name);
}
