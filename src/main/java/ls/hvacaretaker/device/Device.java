package ls.hvacaretaker.device;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.job.Job;
import ls.hvacaretaker.job.JobType;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.refrigerant.Refrigerant;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Encja obiektu Device.
 * Reprezentuje urządzenie do obróbki powietrza.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true, name = "serial_number")
    private String serialNumber;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false, name = "production_date")
    private LocalDate productionDate;
    @ManyToOne
    @JoinColumn(name = "producent_id")
    private Producent producent;
    @Column(name = "device_value")
    private Double value;
    @Column(name = "cooling_power")
    private Double coolingPower;
    @ManyToOne
    @JoinColumn(name = "refrigerant_id")
    private Refrigerant refrigerant;
    @Column(name = "refrigerant_mass")
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
     * Gets serial number.
     *
     * @return the serial number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets serial number.
     *
     * @param serialNumber the serial number
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets production date.
     *
     * @return the production date
     */
    public LocalDate getProductionDate() {
        return productionDate;
    }

    /**
     * Sets production date.
     *
     * @param productionDate the production date
     */
    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * Gets producent.
     *
     * @return the producent
     */
    public Producent getProducent() {
        return producent;
    }

    /**
     * Sets producent.
     *
     * @param producent the producent
     */
    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Gets cooling power.
     *
     * @return the cooling power
     */
    public Double getCoolingPower() {
        return coolingPower;
    }

    /**
     * Sets cooling power.
     *
     * @param coolingPower the cooling power
     */
    public void setCoolingPower(Double coolingPower) {
        this.coolingPower = coolingPower;
    }

    /**
     * Gets refrigerant.
     *
     * @return the refrigerant
     */
    public Refrigerant getRefrigerant() {
        return refrigerant;
    }

    /**
     * Sets refrigerant.
     *
     * @param refrigerant the refrigerant
     */
    public void setRefrigerant(Refrigerant refrigerant) {
        this.refrigerant = refrigerant;
    }

    /**
     * Gets refrigerant mass.
     *
     * @return the refrigerant mass
     */
    public Double getRefrigerantMass() {
        return refrigerantMass;
    }

    /**
     * Sets refrigerant mass.
     *
     * @param refrigerantMass the refrigerant mass
     */
    public void setRefrigerantMass(Double refrigerantMass) {
        this.refrigerantMass = refrigerantMass;
    }

    /**
     * Gets localization.
     *
     * @return the localization
     */
    public String getLocalization() {
        return localization;
    }

    /**
     * Sets localization.
     *
     * @param localization the localization
     */
    public void setLocalization(String localization) {
        this.localization = localization;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets job list.
     *
     * @return the job list
     */
    public List<Job> getJobList() {
        return jobList;
    }

    /**
     * Sets job list.
     *
     * @param jobList the job list
     */
    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    /**
     * Gets last hermetic control.
     *
     * @return the last hermetic control
     */
    public LocalDate getLastHermeticControl() {
        return lastHermeticControl;
    }

    /**
     * Sets last hermetic control.
     *
     * @param nextHermeticControl the next hermetic control
     */
    public void setLastHermeticControl(LocalDate nextHermeticControl) {
        this.lastHermeticControl = nextHermeticControl;
    }

    /**
     * Gets next hermetic control.
     *
     * @return the next hermetic control
     */
    public LocalDate getNextHermeticControl() {
        return nextHermeticControl;
    }

    /**
     * Sets next hermetic control.
     *
     * @param nextHermeticControl the next hermetic control
     */
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

    /**
     * Add job.
     *
     * @param job the job
     */
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
