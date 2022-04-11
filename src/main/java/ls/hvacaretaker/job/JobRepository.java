package ls.hvacaretaker.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repozytorium dla obiektów typu Job
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
