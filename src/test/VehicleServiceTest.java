package test;

import org.junit.jupiter.api.Test;
import service.VehicleService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleServiceTest {

    private final VehicleService service =
            new VehicleService();

    @Test
    public void testToyotaCamry() {

        assertEquals(
                "UDS",
                service.detectProtocol(
                        "Toyota",
                        "Camry",
                        2020
                )
        );
    }

    @Test
    public void testToyotaCorolla() {

        assertEquals(
                "UDS",
                service.detectProtocol(
                        "Toyota",
                        "Corolla",
                        2019
                )
        );
    }

    @Test
    public void testBMWX5() {

        assertEquals(
                "ISO15765",
                service.detectProtocol(
                        "BMW",
                        "X5",
                        2018
                )
        );
    }

    @Test
    public void testAudiA6() {

        assertEquals(
                "UDS",
                service.detectProtocol(
                        "Audi",
                        "A6",
                        2021
                )
        );
    }

    @Test
    public void testUnknownVehicle() {

        assertEquals(
                "Автомобиль не поддерживается",
                service.detectProtocol(
                        "Lada",
                        "Vesta",
                        2024
                )
        );
    }
}