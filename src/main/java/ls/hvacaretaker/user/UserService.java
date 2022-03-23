package ls.hvacaretaker.user;

import ls.hvacaretaker.security.Role;
import ls.hvacaretaker.security.RoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveNewUser(User user) throws RoleNotFoundException{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setAccountActivation(false);
        user.setAccountExpiration(true);
        user.setAccountLock(true);
        user.setCredentialExpiration(true);
        user.addRoles(roleRepository.findByName("USER").orElseThrow(RoleNotFoundException::new));
        userRepository.save(user);
    }
}
