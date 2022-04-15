package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;

import java.util.List;

/**
 * Obiekt DTO typu Refrigerant
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
public class RefrigerantDto {

    private Long id;
    private String name;
    private int GWP;
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
}
