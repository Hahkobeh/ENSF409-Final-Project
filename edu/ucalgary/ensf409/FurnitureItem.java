package edu.ucalgary.ensf409;

public class FurnitureItem {
    private String type;
    private int IDNumber;
    private int price;
    private Manufacturer manufacturer;
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getIDNumber() {
        return IDNumber;
    }
    public void setIDNumber(int iDNumber) {
        this.IDNumber = iDNumber;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    



}
