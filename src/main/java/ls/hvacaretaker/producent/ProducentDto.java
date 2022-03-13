package ls.hvacaretaker.producent;

import ls.hvacaretaker.device.Device;

import java.util.List;

public class ProducentDto {

    private Long id;
    private String name;
    private List<Device> deviceList;

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

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
