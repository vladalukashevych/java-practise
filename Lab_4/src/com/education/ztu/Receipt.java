package com.education.ztu;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class Receipt {
    public static void Print(String[][] purchases) {
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.data", locale);

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String dateTime = currentDateTime.format(dateTimeFormatter);

        Formatter formatter = new Formatter();
        formatter.format(resourceBundle.getString("purchase.dateTime") + "\t\t\t\t\t\t" + dateTime + "\n");
        formatter.format(resourceBundle.getString("purchase.separationLine") + "\n");
        formatter.format(resourceBundle.getString("purchase.itemListHeader") + "\n");
        formatter.format(resourceBundle.getString("purchase.separationLine") + "\n");

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String currencyCode = currencyFormat.getCurrency().getCurrencyCode();

        for (int i = 0; i < purchases.length; i++) {
            formatter.format("%-4d %-15s %-20s %-9s " + currencyCode + "\n",
                    i + 1, purchases[i][0], purchases[i][1], purchases[i][2]);
        }

        double total = calculateTotal(purchases);
        formatter.format(resourceBundle.getString("purchase.separationLine") + "\n");
        formatter.format(resourceBundle.getString("purchase.total") + "   " + currencyCode, total);

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