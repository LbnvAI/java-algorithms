package org.anton.hexlet.module4.fruit_market;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class ProductDAO {
    Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public Optional<Product> findProductByName(String name) throws SQLException {
        var sql1 = "SELECT * FROM products WHERE title = ?";
        try (var pstmt = connection.prepareStatement(sql1)) {
            pstmt.setString(1, name);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                var id = rs.getLong("id");
                var title = rs.getString("title");
                var description = rs.getString("description");
                var price = rs.getDouble("price");
                return Optional.of(new Product(id, title, description, price));
            }
            return Optional.empty();
        }
    }
}
