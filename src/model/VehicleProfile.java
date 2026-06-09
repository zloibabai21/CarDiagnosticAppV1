package model;

public class VehicleProfile {

    private String brand;
    private String model;
    private int year;
    private String protocol;

    public VehicleProfile(String brand, String model, int year, String protocol) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.protocol = protocol;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getProtocol() {
        return protocol;
    }
}