package ls.hvacaretaker.user;

import ls.hvacaretaker.security.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

/**
 * Warstwa usług typu User
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * Konstruktor wstrzykujący poniższe zależności
     *
     * @param userRepository repozytorium obiektów typu User
     * @param roleRepository repozytorium obiektów typu Role
     */
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Zapisuje do bazy danych nowy obiekt typu User na podstawie przekazanego w parametrze obiektu User.
     *
     * @param user obiekt typu User
     * @throws RoleNotFoundException rzucany, gdy ustawiona dla użytkownika rola nie zostanie odnaleziona w bazie danych.
     */
    public void saveNewUser(User user) throws RoleNotFoundException{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setAccountActivation(true);
        user.setAccountExpiration(true);
        user.setAccountLock(true);
        user.setCredentialExpiration(true);
        user.addRoles(roleRepository.findByName("USER").orElseThrow(RoleNotFoundException::new));
        userRepository.save(user);
    }

    /**
     * Metoda obsługująca zmianę hasła użytkownika.
     *
     * @param id          numer id użtywkonika
     * @param oldPassword stare hasło użytkownika
     * @param newPassword nowe hasło użytkownika
     * @throws IllegalArgumentException rzucany, gdy przesłane stare hasło nie zgadza się z boecnym w bazie danych
     */
    public void changeUserPassword(Long id, String oldPassword, String newPassword) throws IllegalArgumentException {
        Optional<User> existingUser = userRepository.findById(id);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        existingUser.ifPresent(user -> {
            if (bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(bCryptPasswordEncoder.encode(newPassword));
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException();
            }
        });
    }
}
