package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<String[]> getAllProducts() {

        List<String[]> products = new ArrayList<>();

        String sql =
                "SELECT product_id, product_name, product_type, price "
                + "FROM products";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String[] product = {
                    String.valueOf(rs.getInt("product_id")),
                    rs.getString("product_name"),
                    rs.getString("product_type"),
                    String.valueOf(rs.getBigDecimal("price"))
                };

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    
    public boolean productExists(
        String productName,
        String productType,
        int productId) {

    String sql =
            "SELECT COUNT(*) "
            + "FROM products "
            + "WHERE LOWER(product_name) = LOWER(?) "
            + "AND LOWER(product_type) = LOWER(?) "
            + "AND product_id <> ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, productName);
        stmt.setString(2, productType);
        stmt.setInt(3, productId);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
    
    public boolean addProduct(
            String productName,
            String productType,
            double price) {

        String sql =
                "INSERT INTO products "
                + "(product_name, product_type, price) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, productName);
            stmt.setString(2, productType);
            stmt.setDouble(3, price);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(
            int productId,
            String productName,
            String productType,
            double price) {

        String sql =
                "UPDATE products "
                + "SET product_name = ?, "
                + "product_type = ?, "
                + "price = ? "
                + "WHERE product_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, productName);
            stmt.setString(2, productType);
            stmt.setDouble(3, price);
            stmt.setInt(4, productId);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}