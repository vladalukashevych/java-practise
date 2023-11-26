package com.education.ztu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Task3 {
    private static final String REPORT_FILE_PATH = "directory_for_files/purchase_report.txt";

    public static void DoTask() {
        String report = ShopAndReport();

        writeReportToFile(REPORT_FILE_PATH, report);

        readReportFromFile(REPORT_FILE_PATH);
    }

    private static String ShopAndReport() {
        String[][] purchases = {
                {"Джинси", "Жіночий одяг", "1500.78"},
                {"Спідниця", "Жіночий одяг", "1000.56"},
                {"Краватка", "Чоловічий одяг", "500.78"},
                {"Шкарпетки", "Чоловічий одяг", "500.78"},
                {"Футболка", "Чоловічий одяг", "750.99"},
                {"Штани", "Жіночий одяг", "1200.00"},
                {"Сукня", "Жіночий одяг", "2000.25"},
                {"Світшот", "Чоловічий одяг", "900.49"},
                {"Шарф", "Аксесуари", "300.25"},
                {"Капелюх", "Аксесуари", "450.99"},
                {"Кросівки", "Взуття", "1800.75"},
        };

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String dateTime = currentDateTime.format(dateTimeFormatter);

        try (Formatter formatter = new Formatter()) {
            formatter.format("Дата та час покупки: \t\t%s%n", dateTime);
            formatter.format("======================================================\n");
            formatter.format("%-4s %-15s %-20s %-10s%n", "№", "Товар", "Категорія", "Ціна");
            formatter.format("======================================================\n");

            for (int i = 0; i < purchases.length; i++) {
                formatter.format("%-4d %-15s %-20s %-10s ₴%n",
                        i + 1, purchases[i][0], purchases[i][1], purchases[i][2]);
            }

            double total = calculateTotal(purchases);
            formatter.format("======================================================\n");
            formatter.format("Разом: \t\t\t\t\t\t\t\t\t%.2f ₴%n", total);

//            System.out.println(formatter);

            String report = formatter.toString();

            return report;
        }
    }

    private static void writeReportToFile(String fileName, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
            System.out.println("Звіт успішно записано у файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    private static void readReportFromFile(String fileName) {
        try {
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Помилка при читанні з файлу: " + e.getMessage());
        }
    }

    private static double calculateTotal(String[][] purchases) {
        double total = 0;
        for (String[] purchase : purchases) {
            total += Double.parseDouble(purchase[2]);
        }
        return total;
    }
}
