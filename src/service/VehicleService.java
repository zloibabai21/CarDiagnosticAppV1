package service;

import model.VehicleProfile;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private final List<VehicleProfile> vehicles = new ArrayList<>();

    public VehicleService() {

        // Toyota
        vehicles.add(new VehicleProfile("Toyota", "Camry", 2020, "UDS"));
        vehicles.add(new VehicleProfile("Toyota", "Corolla", 2019, "UDS"));
        vehicles.add(new VehicleProfile("Toyota", "RAV4", 2021, "UDS"));

        // BMW
        vehicles.add(new VehicleProfile("BMW", "X5", 2018, "ISO15765"));
        vehicles.add(new VehicleProfile("BMW", "X3", 2020, "ISO15765"));
        vehicles.add(new VehicleProfile("BMW", "320", 2019, "ISO15765"));

        // Audi
        vehicles.add(new VehicleProfile("Audi", "A6", 2021, "UDS"));
        vehicles.add(new VehicleProfile("Audi", "A4", 2020, "UDS"));
        vehicles.add(new VehicleProfile("Audi", "Q7", 2019, "UDS"));

        // Volkswagen
        vehicles.add(new VehicleProfile("Volkswagen", "Passat", 2020, "UDS"));
        vehicles.add(new VehicleProfile("Volkswagen", "Golf", 2019, "UDS"));
        vehicles.add(new VehicleProfile("Volkswagen", "Tiguan", 2021, "UDS"));

        // Mercedes
        vehicles.add(new VehicleProfile("Mercedes", "E200", 2020, "UDS"));
        vehicles.add(new VehicleProfile("Mercedes", "C180", 2019, "UDS"));
        vehicles.add(new VehicleProfile("Mercedes", "GLC", 2021, "UDS"));
    }

    public String detectProtocol(
            String brand,
            String model,
            int year
    ) {

        for (VehicleProfile vehicle : vehicles) {

            if (vehicle.getBrand().equalsIgnoreCase(brand)
                    && vehicle.getModel().equalsIgnoreCase(model)
                    && vehicle.getYear() == year) {

                return vehicle.getProtocol();
            }
        }

        return "Автомобиль не поддерживается";
    }
}