package com.education.ztu;

import java.io.File;
import java.io.IOException;

public class Task6 {
    public static void DoTask() {
        File innerDirectory = new File("directory_for_files\\inner_directory");

        createDirectory(innerDirectory);

        System.out.println("Absolute path: " + innerDirectory.getAbsolutePath());

        System.out.println("Parent directory: " + innerDirectory.getParent());

        createFile(innerDirectory, "file1.txt");
        createFile(innerDirectory, "file2.txt");

        deleteFile(new File(innerDirectory, "file1.txt"));

        renameDirectory(innerDirectory, "renamed_inner_directory");

        printDirectoriesAndFiles("directory_for_files");

    }

    private static void createDirectory(File directory) {
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Created directory: " + directory.getAbsolutePath());
            } else {
                System.out.println("Error creating directory: " + directory.getAbsolutePath());
            }
        }
    }
    private static void createFile(File directory, String fileName) {
        File file = new File(directory, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Created file: " + file.getAbsolutePath());
            } else {
                System.out.println("Error creating file: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile(File file) {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Deleted file: " + file.getAbsolutePath());
            } else {
                System.out.println("Error deleting file: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }

    private static void renameDirectory(File directory, String newName) {
        File newDirectory = new File(directory.getParent(), newName);
        if (directory.renameTo(newDirectory)) {
            System.out.println("Directory renamed: " + newDirectory.getAbsolutePath());
        } else {
            System.out.println("Error renaming directory: " + directory.getAbsolutePath());
        }
    }

    private static void printDirectoriesAndFiles(String path) {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                StringBuilder list = new StringBuilder();
                for (File file : files) {
                    list.append("Name: " + file.getName());
                    list.append("\nSize: " + file.length() + " byte");
                    list.append("\nType: " + (file.isDirectory() ? "directory" : "file"));
                    list.append("\n\n");
                }
                System.out.println(list);
            } else {
                System.out.println("No files found.");
            }
        } else {
            System.out.println("Directory does not exist: " + directory.getAbsolutePath());
        }
    }
}
