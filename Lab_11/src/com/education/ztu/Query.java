package com.education.ztu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Query {
    private Connection connection;

    public Query(Connection curConnection) {
        connection = curConnection;
    }

    public List<Product> SelectAll() {
        return executeSelectQuery("SELECT * FROM products");
    }

    public List<Product> SelectAllByCategory(String category) {
        String query = "SELECT * FROM products WHERE category = '" + category + "'";
        return executeSelectQuery(query);
    }

    public List<Product> SelectAllByBrand(String brand) {
        String query = "SELECT * FROM products WHERE brand = '" + brand + "'";
        return executeSelectQuery(query);
    }

    private List<Product> executeSelectQuery(String query) {
        List<Product> results = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product obj = new Product();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setCount(resultSet.getInt("count"));
                obj.setCategory(resultSet.getString("category"));
                obj.setBrand(resultSet.getString("brand"));

                results.add(obj);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public void DeleteAll() {
        try {
            Statement statement = connection.createStatement();

            String query = "DELETE FROM products";
            int rowsAffected = statement.executeUpdate(query);

            System.out.println("Rows affected: " + rowsAffected);

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
