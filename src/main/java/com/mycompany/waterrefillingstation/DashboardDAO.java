package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DashboardDAO {

    // Get today's transactions
    public List<String[]> getTodayTransactions() {

        List<String[]> transactions =
                new ArrayList<>();

        String sql =
                "SELECT o.order_id, "
                + "CONCAT(c.first_name, ' ', c.last_name) AS customer, "
                + "o.order_date, "
                + "o.order_type, "
                + "o.delivery_status, "
                + "o.delivery_fee, "
                + "o.total_amount "
                + "FROM orders o "
                + "JOIN customers c "
                + "ON o.customer_id = c.customer_id "
                + "WHERE DATE(o.order_date) = CURDATE() "
                + "ORDER BY o.order_date DESC";

        try (Connection conn =
                     DBConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            while (rs.next()) {

                String[] transaction = {
                    
                    String.valueOf(rs.getInt("order_id")),
                    
                    rs.getString("customer"),
                    
                    String.valueOf(rs.getTimestamp("order_date")),
                    
                    rs.getString("order_type"),
                    
                    rs.getString("delivery_status"),
                    
                    String.valueOf(rs.getBigDecimal("delivery_fee")),
                    
                    String.valueOf(rs.getBigDecimal("total_amount"))
                        
                };

                transactions.add(transaction);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return transactions;
    }


    // Get active customer count
    public int getCustomerCount() {

        String sql =
                "SELECT COUNT(*) "
                + "FROM customers "
                + "WHERE is_archived = 0";

        try (Connection conn =
                     DBConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            if (rs.next()) {

                return rs.getInt(1);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }


    // Get product count
    public int getProductCount() {

        String sql =
                "SELECT COUNT(*) "
                + "FROM products";

        try (Connection conn =
                     DBConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql);
             ResultSet rs =
                     stmt.executeQuery()) {

            if (rs.next()) {

                return rs.getInt(1);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }
    
    public int getPendingDeliveryCount() {

        String sql =
                "SELECT COUNT(*) "
                + "FROM orders "
                + "WHERE DATE(order_date) = CURDATE() "
                + "AND order_type = 'Delivery' "
                + "AND delivery_status IN "
                + "('Pending', 'Out for Delivery')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    // Update delivery status
public boolean updateDeliveryStatus(
        int orderId,
        String deliveryStatus) {

        String sql =
                "UPDATE orders "
                + "SET delivery_status = ? "
                + "WHERE order_id = ? "
                + "AND order_type = 'Delivery'";

        try (Connection conn =
                     DBConnection.getConnection();
             PreparedStatement stmt =
                     conn.prepareStatement(sql)) {

            stmt.setString(1, deliveryStatus);
            stmt.setInt(2, orderId);

            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}