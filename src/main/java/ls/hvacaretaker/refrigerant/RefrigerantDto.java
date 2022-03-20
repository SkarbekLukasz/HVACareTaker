package ls.hvacaretaker.refrigerant;

import ls.hvacaretaker.device.Device;

import java.util.List;

public class RefrigerantDto {

    private Long id;
    private String name;
    private int GWP;
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

    public int getGWP() {
        return GWP;
    }

    public void setGWP(int GWP) {
        this.GWP = GWP;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}
