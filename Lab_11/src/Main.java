import com.education.ztu.Product;
import com.education.ztu.Query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static com.education.ztu.DatabaseConnection.getConnection;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");

                Query query = new Query(connection);

//                List<Product> allProducts = query.SelectAll();
//                List<Product> allProducts = query.SelectAllByCategory("Electronics");
                List<Product> allProducts = query.SelectAllByBrand("Brand A");

                for (Product product : allProducts) {
                    System.out.println(product);
                }

//                query.DeleteAll();
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}