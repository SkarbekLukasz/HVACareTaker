package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "producent")
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "producent")
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
        Producent producent = (Producent) o;
        return Objects.equals(id, producent.id) && Objects.equals(name, producent.name) && Objects.equals(devices, producent.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, devices);
    }

    public void addDevice(Device device) {
        devices.add(device);
    }
}
