package ls.hvacaretaker.refrigerant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefrigerantRepository extends JpaRepository<Refrigerant, Long> {
    List<Refrigerant> findAll();
}
