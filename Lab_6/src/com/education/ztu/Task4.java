package com.education.ztu;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task4 {
    private static final String FILE_PATH = "directory_for_files/docs_img.docx";
    private static final String FILE_PATH_COPY = "directory_for_files/docs_img_copy.docx";
    public static void DoTask() {
        copyFile(FILE_PATH, FILE_PATH_COPY);

        System.out.println("Копіювання завершено.");
    }

    private static void copyFile(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);

            Files.copy(source, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
