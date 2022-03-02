package ls.hvacaretaker.category;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Device> getDevices() {
        return devices;
    }

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
}
