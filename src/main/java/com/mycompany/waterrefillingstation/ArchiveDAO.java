package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArchiveDAO {

    // GET ARCHIVED CUSTOMERS
    public List<String[]> getArchivedCustomers() {

        List<String[]> customers = new ArrayList<>();

        String sql = "SELECT customer_id, first_name, last_name, "
                   + "contact_number, address "
                   + "FROM customers "
                   + "WHERE is_archived = 1";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String[] customer = {
                    String.valueOf(rs.getInt("customer_id")),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("contact_number"),
                    rs.getString("address")
                };

                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    // RESTORE CUSTOMER
    public boolean restoreCustomer(int customerId) {

        String sql = "UPDATE customers "
                   + "SET is_archived = 0 "
                   + "WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}