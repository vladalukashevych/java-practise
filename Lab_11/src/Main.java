import com.education.ztu.Product;
import com.education.ztu.Query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
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


//  -------------------------------------------------------------------
                System.out.println();
                connection.setAutoCommit(false);

                Product productK = new Product("Product K", 7, "Toys", "Brand B");
                Product productL = new Product("Product L", 3, "House", "Brand A");

                query.AddProduct(productK);
                Savepoint savepoint = connection.setSavepoint("productK");

                query.AddProductSyntaxError(productL);
                connection.rollback(savepoint);

                connection.releaseSavepoint(savepoint);
                connection.commit();

            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}