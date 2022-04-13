package ls.hvacaretaker.device;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.job.Job;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.refrigerant.Refrigerant;

import java.time.LocalDate;
import java.util.List;

/**
 * Obiekt DTO dla typu Device.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
public class DeviceDto {

    private Long id;
    private String name;
    private String serialNumber;
    private String model;
    private LocalDate productionDate;
    private Producent producent;
    private Double value;
    private Double coolingPower;
    private Refrigerant refrigerant;
    private Double refrigerantMass;
    private String localization;
    private Category category;
    private List<Job> jobList;
    private LocalDate lastHermeticControl;
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
     * @param lastHermeticControl the last hermetic control
     */
    public void setLastHermeticControl(LocalDate lastHermeticControl) {
        this.lastHermeticControl = lastHermeticControl;
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
}
