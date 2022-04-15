package ls.hvacaretaker.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium obiektów typu User
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Wyszukuje użytkownika na podstawie adresu email, będącym jednocześnie loginem do aplikacji.
     *
     * @param email adres email użytkownika
     * @return obiekt typu User
     */
    User findByEmail(String email);
}
