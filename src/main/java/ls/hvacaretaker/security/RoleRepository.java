package ls.hvacaretaker.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repozytorium dla obiektów Role
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Wyszukuje obiekt Role na podstawie przekazanej w parametrze nazwy.
     *
     * @param name nazwa roli
     * @return optional typu Role
     */
    Optional<Role> findByName(String name);
}
