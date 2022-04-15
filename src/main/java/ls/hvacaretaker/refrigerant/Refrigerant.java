package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Encja obiektu Refrigerant
 *
 * Reprezentuje czynniki chłodnicze.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "refrigerant")
public class Refrigerant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private int GWP;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refrigerant")
    private List<Device> devices;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets devices.
     *
     * @return the devices
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Sets devices.
     *
     * @param devices the devices
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    /**
     * Gets gwp.
     *
     * @return the gwp
     */
    public int getGWP() {
        return GWP;
    }

    /**
     * Sets gwp.
     *
     * @param GWP the gwp
     */
    public void setGWP(int GWP) {
        this.GWP = GWP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerant that = (Refrigerant) o;
        return GWP == that.GWP && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(devices, that.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, GWP, devices);
    }

    /**
     * Add device.
     *
     * @param device the device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }


}
