package com.education.ztu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        DatabaseConfig conf = new DatabaseConfig();

        String url = conf.getUrl();
        String user = conf.getUsername();
        String password = conf.getPassword();

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }
}
