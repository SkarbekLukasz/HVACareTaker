package ls.hvacaretaker.category;

import ls.hvacaretaker.device.Device;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Reprezentuje kategorię urządzenia do obróbki powietrza wewnętrznego.
 * Jedna kategoria może być przypisana do wielu urządzeń (Device).
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", devices=" + devices +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(description, category.description) && Objects.equals(devices, category.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, devices);
    }

    /**
     * Add device to list of devices.
     *
     * @param device the device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }
}
