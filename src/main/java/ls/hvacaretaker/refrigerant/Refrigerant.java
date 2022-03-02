package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "refrigerant")
public class Refrigerant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "refrigerant")
    private List<Device> devices;
}
