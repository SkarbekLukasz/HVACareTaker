package ls.hvacaretaker.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAll();
    Optional<Device> findBySerialNumberIgnoreCase(String serial);
}
