package ls.hvacaretaker.producent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducentRepository extends JpaRepository<Producent, Long> {
    List<Producent> findAll();
    Optional<Producent> findByNameIgnoreCase(String name);
    List<Producent> findByNameContainingIgnoreCase(String name);
}
