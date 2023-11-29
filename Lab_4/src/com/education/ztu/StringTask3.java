package com.education.ztu;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class StringTask3 {
    public static void DoTask(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.data", locale);
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

        Formatter formatter = new Formatter();
        formatter.format(resourceBundle.getString("purchase.dateTime") + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + dateTime);
        formatter.format(resourceBundle.getString("purchase.separationLine"));
        formatter.format(resourceBundle.getString("purchase.itemListHeader"));
        formatter.format(resourceBundle.getString("purchase.separationLine"));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//        Currency currentCurrency = Currency.getInstance(locale);
            for (int i = 0; i < purchases.length; i++) {
                formatter.format("%-4d %-15s %-20s %-10s ₴%n",
                        i + 1, purchases[i][0], purchases[i][1], purchases[i][2]);
            }

            double total = calculateTotal(purchases);
            formatter.format(resourceBundle.getString("purchase.separationLine"));
            formatter.format(resourceBundle.getString("purchase.total"), total);

            System.out.println(formatter);

    }

    private static double calculateTotal(String[][] purchases) {
        double total = 0;
        for (String[] purchase : purchases) {
            total += Double.parseDouble(purchase[2]);
        }
        return total;
    }
}
