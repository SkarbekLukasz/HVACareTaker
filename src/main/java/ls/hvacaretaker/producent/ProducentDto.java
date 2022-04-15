package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;

import java.util.List;

/**
 * Obiekt DTO typu Producent.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
public class ProducentDto {

    private Long id;
    private String name;
    private String contactInfo;
    private List<Device> deviceList;

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
     * Gets device list.
     *
     * @return the device list
     */
    public List<Device> getDeviceList() {
        return deviceList;
    }

    /**
     * Sets device list.
     *
     * @param deviceList the device list
     */
    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
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
}
