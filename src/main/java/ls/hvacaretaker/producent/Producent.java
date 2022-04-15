package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Encja obiektu Producent
 *
 * Reprezentuje producenta urządzeń chłodniczych.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "producent")
public class Producent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(length = 1024, name = "contact_info")
    private String contactInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producent")
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
     * Dodaje obiekt Device do listy devices.
     *
     * @param device obiekt Device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * Gets contact info.
     *
     * @return the contact info
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets contact info.
     *
     * @param contactInfo the contact info
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producent producent = (Producent) o;
        return Objects.equals(id, producent.id) && Objects.equals(name, producent.name) && Objects.equals(contactInfo, producent.contactInfo) && Objects.equals(devices, producent.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactInfo, devices);
    }
}
