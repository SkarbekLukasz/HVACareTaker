package ls.hvacaretaker.device;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.job.Job;
import ls.hvacaretaker.job.JobType;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.refrigerant.Refrigerant;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String serialNumber;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private LocalDate productionDate;
    @ManyToOne
    @JoinColumn(name = "producent_id")
    private Producent producent;
    private Double value;
    private Double coolingPower;
    @ManyToOne
    @JoinColumn(name = "refrigerant_id")
    private Refrigerant refrigerant;
    private Double refrigerantMass;
    private String localization;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device", fetch = FetchType.EAGER)
    private List<Job> jobList;
    @Column(name = "last_control")
    private LocalDate lastHermeticControl;
    @Column(name = "next_control")
    private LocalDate nextHermeticControl;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getCoolingPower() {
        return coolingPower;
    }

    public void setCoolingPower(Double coolingPower) {
        this.coolingPower = coolingPower;
    }

    public Refrigerant getRefrigerant() {
        return refrigerant;
    }

    public void setRefrigerant(Refrigerant refrigerant) {
        this.refrigerant = refrigerant;
    }

    public Double getRefrigerantMass() {
        return refrigerantMass;
    }

    public void setRefrigerantMass(Double refrigerantMass) {
        this.refrigerantMass = refrigerantMass;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public LocalDate getLastHermeticControl() {
        return lastHermeticControl;
    }

    public void setLastHermeticControl(LocalDate nextHermeticControl) {
        this.lastHermeticControl = nextHermeticControl;
    }

    public LocalDate getNextHermeticControl() {
        return nextHermeticControl;
    }

    public void setNextHermeticControl(LocalDate nextHermeticControl) {
        this.nextHermeticControl = nextHermeticControl;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", producent=" + producent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(id, device.id) && Objects.equals(name, device.name) && Objects.equals(serialNumber, device.serialNumber) && Objects.equals(model, device.model) && Objects.equals(productionDate, device.productionDate) && Objects.equals(producent, device.producent) && Objects.equals(value, device.value) && Objects.equals(coolingPower, device.coolingPower) && Objects.equals(refrigerant, device.refrigerant) && Objects.equals(refrigerantMass, device.refrigerantMass) && Objects.equals(localization, device.localization) && Objects.equals(category, device.category) && Objects.equals(jobList, device.jobList) && Objects.equals(lastHermeticControl, device.lastHermeticControl) && Objects.equals(nextHermeticControl, device.nextHermeticControl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, model, productionDate, producent, value, coolingPower, refrigerant, refrigerantMass, localization, category, jobList, lastHermeticControl, nextHermeticControl);
    }

    public void addJob(Job job) {
        if(job.getJobType().equals(JobType.HERMETICTEST)) {
            setLastHermeticControl(job.getJobEndTime());
            double co2 = getRefrigerantMass() * getRefrigerant().getGWP();
            if (co2 > 5000.00 && co2 < 50000.00) {
                setNextHermeticControl(getLastHermeticControl().plusMonths(12));
            } else if (co2 > 50000.00) {
                setNextHermeticControl(getLastHermeticControl().plusMonths(6));
            }
        }
        getJobList().add(job);
    }
}
