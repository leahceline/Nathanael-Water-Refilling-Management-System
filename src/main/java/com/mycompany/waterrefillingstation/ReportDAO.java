package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public List<String[]> getTransactionsByPeriod(String period) {

        List<String[]> transactions = new ArrayList<>();

        String sql =
                "SELECT o.order_id, "
                + "CONCAT(c.first_name, ' ', c.last_name) AS customer, "
                + "c.address, "
                + "o.order_date, "
                + "o.order_type, "
                + "o.delivery_status, "
                + "o.delivery_fee, "
                + "o.total_amount, "
                + "p.amount_paid, "
                + "p.change_amount, "
                + "p.payment_method, "
                + "p.reference_code "
                + "FROM orders o "
                + "JOIN customers c "
                + "ON o.customer_id = c.customer_id "
                + "JOIN payments p "
                + "ON o.order_id = p.order_id ";

        if (period.equalsIgnoreCase("Daily")) {

            sql += "WHERE DATE(o.order_date) = CURDATE() ";

        } else if (period.equalsIgnoreCase("Weekly")) {

            sql += "WHERE YEARWEEK(o.order_date, 1) "
                    + "= YEARWEEK(CURDATE(), 1) ";

        } else if (period.equalsIgnoreCase("Monthly")) {

            sql += "WHERE YEAR(o.order_date) = YEAR(CURDATE()) "
                    + "AND MONTH(o.order_date) = MONTH(CURDATE()) ";

        } else if (period.equalsIgnoreCase("Yearly")) {

            sql += "WHERE YEAR(o.order_date) = YEAR(CURDATE()) ";
        }

        sql += "ORDER BY o.order_date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String[] transaction = {

                    String.valueOf(
                            rs.getInt("order_id")
                    ),

                    rs.getString("customer"),

                    rs.getString("address"),

                    String.valueOf(
                            rs.getTimestamp("order_date")
                    ),

                    rs.getString("order_type"),

                    rs.getString("delivery_status"),

                    String.valueOf(
                            rs.getBigDecimal("delivery_fee")
                    ),

                    String.valueOf(
                            rs.getBigDecimal("total_amount")
                    ),

                    String.valueOf(
                            rs.getBigDecimal("amount_paid")
                    ),

                    String.valueOf(
                            rs.getBigDecimal("change_amount")
                    ),

                    rs.getString("payment_method"),

                    rs.getString("reference_code")
                };

                transactions.add(transaction);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return transactions;
    }

    public boolean updateDeliveryStatus(
            int orderId,
            String deliveryStatus) {

        String sql =
                "UPDATE orders "
                + "SET delivery_status = ? "
                + "WHERE order_id = ? "
                + "AND order_type = 'Delivery'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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