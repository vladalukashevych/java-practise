package com.education.ztu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class StringTask3 {
    public static void DoTask() {
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

            System.out.println(formatter);
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
