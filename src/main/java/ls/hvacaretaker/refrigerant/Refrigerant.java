package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerant that = (Refrigerant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, devices);
    }

    public void addDevice(Device device) {
        devices.add(device);
    }
}
