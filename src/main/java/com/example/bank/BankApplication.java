package com.example.bank;
import java.io.*;
import java.nio.file.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);

        // Folder path containing the files
        String folderPath = "/Users/anna/Development/Spring/SQL"; // Your folder path
        String outputFile = "mergedFile.txt"; // Output file

        mergeFilesInFolder(folderPath, outputFile);




    }

    public static void mergeFilesInFolder(String folderPath, String outputFile) {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return;
        }

        File[] files = folder.listFiles(); // Get all files in the folder
        if (files == null || files.length == 0) {
            System.out.println("No files found in the folder: " + folderPath);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".sql")) { // Process only .sql files
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                        writer.newLine(); // Add a blank line between files
                    }
                    System.out.println("Merged: " + file.getName());
                }
            }
            System.out.println("SQL files merged successfully into " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
