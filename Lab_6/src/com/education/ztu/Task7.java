package com.education.ztu;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Task7 {
    public static void DoTask() {
        String sourceDirectory = "directory_for_files";
        String zipFileName = "archive.zip";

        createZipArchive(sourceDirectory, zipFileName);
        listFilesInZipArchive(zipFileName);
    }

    private static void createZipArchive(String sourceDirectory, String zipFileName) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            addFilesToZip(zipOutputStream, new File(sourceDirectory), "");
            System.out.println("Archive created successfully: " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFilesToZip(ZipOutputStream zipOutputStream, File file, String parentPath) throws IOException {
        if (file.isDirectory()) {
            parentPath += file.getName() + "/";
            zipOutputStream.putNextEntry(new ZipEntry(parentPath));
            zipOutputStream.closeEntry();

            for (File nestedFile : file.listFiles()) {
                addFilesToZip(zipOutputStream, nestedFile, parentPath);
            }
        } else {
            String entryName = parentPath + file.getName();
            zipOutputStream.putNextEntry(new ZipEntry(entryName));

            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, bytesRead);
                }
            }
            zipOutputStream.closeEntry();
        }
    }

    private static void listFilesInZipArchive(String zipFileName) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println("File in archive: " + entry.getName());
                zipInputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
