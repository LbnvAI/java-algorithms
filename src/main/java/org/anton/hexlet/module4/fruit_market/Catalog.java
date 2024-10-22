package org.anton.hexlet.module4.fruit_market;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class Catalog {
    private static final String productDataBaseURL = "jdbc:h2:mem:hexlet";

    public static String getProduct(String title) throws SQLException {
        Connection connection = DriverManager.getConnection(productDataBaseURL);
        var product = new ProductDAO(connection);
        var result = product.findProductByName(title);
        if (result.isEmpty()) throw new NoSuchElementException("Product " + title + " not found");
        else
            return result.get().getId() + " " + result.get().getPrice() + " " + result.get().getTitle() + " " + result.get().getDescription();
    }
}
