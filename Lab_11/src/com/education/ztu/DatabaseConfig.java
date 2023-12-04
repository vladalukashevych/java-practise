package com.education.ztu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {
    private Properties properties;
    private String filePath = "src/resources/db.properties";

    public DatabaseConfig() {
        this.properties = new Properties();
        loadProperties();
    }
    public void loadProperties() {
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
