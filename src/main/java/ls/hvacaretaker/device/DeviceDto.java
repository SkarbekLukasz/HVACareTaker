package ls.hvacaretaker.device;

import ls.hvacaretaker.category.Category;
import ls.hvacaretaker.producent.Producent;
import ls.hvacaretaker.refrigerant.Refrigerant;

import java.util.Date;

public class DeviceDto {

    private Long id;
    private String name;
    private String serialNumber;
    private String model;
    private Date productionDate;
    private Producent producent;
    private Double value;
    private Double coolingPower;
    private Refrigerant refrigerant;
    private Double refrigerantMass;
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

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
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
}
