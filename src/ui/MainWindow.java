package ui;

import service.VehicleService;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final JComboBox<String> brandBox;
    private final JComboBox<String> modelBox;
    private final JComboBox<String> yearBox;

    private final JLabel resultLabel;

    private final VehicleService vehicleService;

    private final String[] toyotaModels = {
            "Camry",
            "Corolla",
            "RAV4"
    };

    private final String[] bmwModels = {
            "X5",
            "X3",
            "320"
    };

    private final String[] audiModels = {
            "A6",
            "A4",
            "Q7"
    };

    private final String[] volkswagenModels = {
            "Passat",
            "Golf",
            "Tiguan"
    };

    private final String[] mercedesModels = {
            "E200",
            "C180",
            "GLC"
    };

    public MainWindow() {

        vehicleService = new VehicleService();

        setTitle("Система диагностики автомобилей");
        setSize(550, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Марка:"));

        brandBox = new JComboBox<>(
                new String[]{
                        "Toyota",
                        "BMW",
                        "Audi",
                        "Volkswagen",
                        "Mercedes"
                }
        );

        add(brandBox);

        add(new JLabel("Модель:"));

        modelBox = new JComboBox<>(toyotaModels);

        add(modelBox);

        add(new JLabel("Год:"));

        yearBox = new JComboBox<>(
                new String[]{
                        "2018",
                        "2019",
                        "2020",
                        "2021"
                }
        );

        add(yearBox);

        JButton detectButton =
                new JButton("Определить протокол");

        JButton clearButton =
                new JButton("Очистить");

        add(detectButton);
        add(clearButton);

        resultLabel =
                new JLabel("Результат:");

        add(resultLabel);

        add(new JLabel(""));

        brandBox.addActionListener(
                e -> updateModels()
        );

        detectButton.addActionListener(
                e -> detectProtocol()
        );

        clearButton.addActionListener(
                e -> clearForm()
        );

        setVisible(true);
    }

    private void updateModels() {

        String brand =
                (String) brandBox.getSelectedItem();

        modelBox.removeAllItems();

        switch (brand) {

            case "Toyota":

                for (String model : toyotaModels) {
                    modelBox.addItem(model);
                }

                break;

            case "BMW":

                for (String model : bmwModels) {
                    modelBox.addItem(model);
                }

                break;

            case "Audi":

                for (String model : audiModels) {
                    modelBox.addItem(model);
                }

                break;

            case "Volkswagen":

                for (String model : volkswagenModels) {
                    modelBox.addItem(model);
                }

                break;

            case "Mercedes":

                for (String model : mercedesModels) {
                    modelBox.addItem(model);
                }

                break;
        }
    }

    private void detectProtocol() {

        String brand =
                (String) brandBox.getSelectedItem();

        String model =
                (String) modelBox.getSelectedItem();

        int year =
                Integer.parseInt(
                        (String) yearBox.getSelectedItem()
                );

        String protocol =
                vehicleService.detectProtocol(
                        brand,
                        model,
                        year
                );

        resultLabel.setText(
                "Результат: " + protocol
        );
    }

    private void clearForm() {

        brandBox.setSelectedIndex(0);

        updateModels();

        modelBox.setSelectedIndex(0);

        yearBox.setSelectedIndex(0);

        resultLabel.setText(
                "Результат:"
        );
    }
}