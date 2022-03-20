package ls.hvacaretaker.refrigerant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@Repository
public interface RefrigerantRepository extends JpaRepository<Refrigerant, Long> {
    List<Refrigerant> findAll();
    Optional<Refrigerant> findByNameIgnoreCase(String name);
    List<Refrigerant> findAllByNameContainingIgnoreCase(String name);
}
