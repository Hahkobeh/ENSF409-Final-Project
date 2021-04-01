package edu.ucalgary.ensf409;

public class Manufacturer {
    private String manuid;
    private String name;
    private String phone;
    private String province;
    public String getProvince() {
        return province;
    }
    public String getManuid() {
        return manuid;
    }
    public void setManuid(String manuid) {
        this.manuid = manuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setProvince(String province) {
        this.province = province;
    }

}
