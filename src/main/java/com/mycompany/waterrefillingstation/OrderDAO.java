package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OrderDAO {

    public boolean saveTransaction(
            int customerId,
            int userId,
            String orderType,
            String deliveryStatus,
            double deliveryFee,
            double totalAmount,
            double amountPaid,
            double changeAmount,
            String paymentMethod,
            String referenceCode,
            List<Object[]> items) {

        String orderSql =
                "INSERT INTO orders "
                + "(customer_id, user_id, order_type, delivery_status, "
                + "delivery_fee, total_amount) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        String itemSql =
                "INSERT INTO order_items "
                + "(order_id, product_id, quantity, unit_price, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        String paymentSql =
                "INSERT INTO payments "
                + "(order_id, amount_paid, change_amount, "
                + "payment_method, reference_code) "
                + "VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;

        try {

            conn = DBConnection.getConnection();

            conn.setAutoCommit(false);

            int orderId;

            // ==========================================
            // 1. SAVE ORDER
            // ==========================================
            try (PreparedStatement stmt =
                    conn.prepareStatement(
                            orderSql,
                            PreparedStatement.RETURN_GENERATED_KEYS)) {

                stmt.setInt(1, customerId);
                stmt.setInt(2, userId);
                stmt.setString(3, orderType);
                stmt.setString(4, deliveryStatus);
                stmt.setDouble(5, deliveryFee);
                stmt.setDouble(6, totalAmount);

                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {

                    if (!rs.next()) {

                        conn.rollback();

                        return false;
                    }

                    orderId = rs.getInt(1);
                }
            }

            // ==========================================
            // 2. SAVE ORDER ITEMS
            // ==========================================
            try (PreparedStatement stmt =
                    conn.prepareStatement(itemSql)) {

                for (Object[] item : items) {

                    int productId =
                            (int) item[0];

                    int quantity =
                            (int) item[1];

                    double unitPrice =
                            (double) item[2];

                    double subtotal =
                            (double) item[3];

                    stmt.setInt(1, orderId);
                    stmt.setInt(2, productId);
                    stmt.setInt(3, quantity);
                    stmt.setDouble(4, unitPrice);
                    stmt.setDouble(5, subtotal);

                    stmt.addBatch();
                }

                stmt.executeBatch();
            }

            // ==========================================
            // 3. SAVE PAYMENT
            // ==========================================
            try (PreparedStatement stmt =
                    conn.prepareStatement(paymentSql)) {

                stmt.setInt(1, orderId);
                stmt.setDouble(2, amountPaid);
                stmt.setDouble(3, changeAmount);
                stmt.setString(4, paymentMethod);
                stmt.setString(5, referenceCode);

                stmt.executeUpdate();
            }

            // ==========================================
            // 4. COMMIT EVERYTHING
            // ==========================================
            conn.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            if (conn != null) {

                try {

                    conn.rollback();

                } catch (Exception rollbackError) {

                    rollbackError.printStackTrace();
                }
            }

            return false;

        } finally {

            if (conn != null) {

                try {

                    conn.setAutoCommit(true);
                    conn.close();

                } catch (Exception closeError) {

                    closeError.printStackTrace();
                }
            }
        }
    }
}