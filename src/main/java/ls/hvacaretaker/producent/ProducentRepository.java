package ls.hvacaretaker.producent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducentRepository extends JpaRepository<Producent, Long> {
    List<Producent> findAll();
}
