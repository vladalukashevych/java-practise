package com.education.ztu.dao;

import com.education.ztu.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO extends AbstractDAO {
    public ProductDAO(Connection connection, String tableName) {

        this.connection = connection;
        this.tableName = tableName;
    }

    public Product get(int id) throws SQLException {
        return executeSelect("SELECT * FROM " + tableName + " WHERE id = " + id).getFirst();
    }

    public List<Product> getAll() throws SQLException {
        return executeSelect("SELECT * FROM " + tableName);
    }

    private List<Product> executeSelect(String query) throws SQLException {
        List<Product> results = new ArrayList<>();

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

        return results;
    }

    public int save(Object object) throws SQLException {
        Product product = (Product) object;

        Statement statement = connection.createStatement();
        String query = String.format("INSERT INTO %s (name, count, category, brand) " +
                        "VALUES (\"%s\", %d, \"%s\", \"%s\")", tableName, product.getName(),
                product.getCount(), product.getCategory(), product.getBrand());

        int rowsAffected = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        int generatedKey = 0;
        if (resultSet.next()) {
            generatedKey = resultSet.getInt(1);
        }

        System.out.println("Rows affected: " + rowsAffected);
        statement.close();
        return generatedKey;
    }

    public void update(int id, Object object) throws SQLException {
        Product product = (Product) object;

        Statement statement = connection.createStatement();
        String query = String.format(
                "UPDATE %s SET name = \"%s\", count = %d, category = \"%s\", brand = \"%s\" WHERE id = %d",
                tableName, product.getName(), product.getCount(), product.getCategory(),
                product.getBrand(), id);

        int rowsAffected = statement.executeUpdate(query);

        System.out.println("Rows affected: " + rowsAffected);
        statement.close();

    }

    public void delete(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "DELETE FROM " + tableName + " WHERE id = " + id;
        int rowsAffected = statement.executeUpdate(query);

        System.out.println("Rows affected: " + rowsAffected);
        statement.close();

    }
}
