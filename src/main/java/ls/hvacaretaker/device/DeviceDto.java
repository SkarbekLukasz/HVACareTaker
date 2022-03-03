package ls.hvacaretaker.device;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.refrigerant.Refrigerant;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DeviceDto {

    private Long id;
    private String name;
    private String serialNumber;
    private String model;
    private LocalDateTime productionDate;
    private Producent producent;
    private BigDecimal value;
    private double coolingPower;
    private Refrigerant refrigerant;
    private double refrigerantMass;
    private String localization;
    private Category category;

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

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public double getCoolingPower() {
        return coolingPower;
    }

    public void setCoolingPower(double coolingPower) {
        this.coolingPower = coolingPower;
    }

    public Refrigerant getRefrigerant() {
        return refrigerant;
    }

    public void setRefrigerant(Refrigerant refrigerant) {
        this.refrigerant = refrigerant;
    }

    public double getRefrigerantMass() {
        return refrigerantMass;
    }

    public void setRefrigerantMass(double refrigerantMass) {
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
}
