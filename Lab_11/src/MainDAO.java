import com.education.ztu.Product;
import com.education.ztu.dao.AbstractDAO;
import com.education.ztu.dao.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import static com.education.ztu.DatabaseConnection.getConnection;

public class MainDAO {
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                Product product = new Product("Product Z", 9, "Outdoor", "Brand D");
                ProductDAO dao = new ProductDAO(connection, "products");

                System.out.println("Saving product: " + product);
                int id = dao.save(product);

                System.out.println("\nChanging category to \"Beauty\"");
                product.setCategory("Beauty");
                dao.update(id, product);
                System.out.println(dao.get(id));

                System.out.println("\nDeleting current product");
                dao.delete(id);
                for (Product pr : dao.getAll()) {
                    System.out.println(pr);
                }

            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
