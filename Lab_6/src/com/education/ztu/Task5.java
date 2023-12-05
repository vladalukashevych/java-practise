package com.education.ztu;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

public class Task5 {
    public static void DoTask() {
        try {
            RandomAccessFile purchaseReport = new RandomAccessFile("directory_for_files/purchase_report.txt", "rw");

            // finding position of last item in the report
            long lastItemPos = findInsertPosition(purchaseReport, "11 ");

            // saving text after the last item
            purchaseReport.seek(lastItemPos);
            String content = readContentAfterPosition(purchaseReport);

            // writing new items to the list
            Formatter formatter = new Formatter();
            formatter.format("%-4d %-15s %-20s %-10s ₴%n", 12, "Сережки", "Аксесуари", "127.00");
            formatter.format("%-4d %-15s %-20s %-10s ₴%n", 13, "Парасоль", "Аксесуари", "867.99");

            purchaseReport.seek(lastItemPos);
            purchaseReport.write(formatter.toString().getBytes());

            // writing previously saved text
            purchaseReport.seek(purchaseReport.length());
            purchaseReport.write(content.getBytes());

            // writing wishes to the end
            purchaseReport.seek(purchaseReport.length());
            String last = "\nДякуємо! Гарного дня!";
            purchaseReport.write(last.getBytes());

            purchaseReport.seek(0);
            System.out.println(readContentAfterPosition(purchaseReport));
            purchaseReport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long findInsertPosition(RandomAccessFile randomAccessFile, String searchText) throws IOException {
        long position = 0;
        String line;
        while ((line = randomAccessFile.readLine()) != null) {
            position = randomAccessFile.getFilePointer();
            if (line.contains(searchText)) {
                break;
            }
        }
        return position;
    }

    private static String readContentAfterPosition(RandomAccessFile randomAccessFile) throws IOException {
        StringBuilder content = new StringBuilder();
        int bytesRead;
        byte[] buffer = new byte[1024];

        while ((bytesRead = randomAccessFile.read(buffer)) != -1) {
            content.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
        }

        return content.toString();
    }
}
