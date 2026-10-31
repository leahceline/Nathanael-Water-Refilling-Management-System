package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // ==========================================
    // GET ALL ACTIVE CUSTOMERS
    // ==========================================
    public List<String[]> getAllCustomers() {

        List<String[]> customers = new ArrayList<>();

        String sql =
                "SELECT customer_id, first_name, last_name, "
                + "contact_number, address "
                + "FROM customers "
                + "WHERE is_archived = 0";

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

    public boolean customerExists(
        String firstName,
        String lastName,
        String contactNumber,
        String address,
        int customerId) {

    String sql =
            "SELECT COUNT(*) "
            + "FROM customers "
            + "WHERE first_name = ? "
            + "AND last_name = ? "
            + "AND contact_number = ? "
            + "AND address = ? "
            + "AND customer_id <> ? "
            + "AND is_archived = 0";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setString(3, contactNumber);
        stmt.setString(4, address);
        stmt.setInt(5, customerId);

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

    // ==========================================
    // CHECK DUPLICATE CUSTOMER FOR UPDATE
    // ==========================================
    public boolean customerExistsForUpdate(
            int customerId,
            String firstName,
            String lastName,
            String contactNumber,
            String address) {

        String sql =
                "SELECT COUNT(*) FROM customers "
                + "WHERE first_name = ? "
                + "AND last_name = ? "
                + "AND contact_number = ? "
                + "AND address = ? "
                + "AND customer_id <> ? "
                + "AND is_archived = 0";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, contactNumber);
            stmt.setString(4, address);
            stmt.setInt(5, customerId);

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


    // ==========================================
    // ADD CUSTOMER
    // ==========================================
    public boolean addCustomer(
            String firstName,
            String lastName,
            String contactNumber,
            String address) {

        String sql =
                "INSERT INTO customers "
                + "(first_name, last_name, contact_number, address) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, contactNumber);
            stmt.setString(4, address);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ==========================================
    // UPDATE CUSTOMER
    // ==========================================
    public boolean updateCustomer(
            int customerId,
            String firstName,
            String lastName,
            String contactNumber,
            String address) {

        String sql =
                "UPDATE customers SET "
                + "first_name = ?, "
                + "last_name = ?, "
                + "contact_number = ?, "
                + "address = ? "
                + "WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, contactNumber);
            stmt.setString(4, address);
            stmt.setInt(5, customerId);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // ==========================================
    // ARCHIVE CUSTOMER
    // ==========================================
    public boolean archiveCustomer(int customerId) {

        String sql =
            "UPDATE customers "
            + "SET is_archived = 1 "
            + "WHERE customer_id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, customerId);

        int rowsUpdated = stmt.executeUpdate();

        return rowsUpdated > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
}    
    public String getCustomerAddress(int customerId) {

        String sql =
                "SELECT address "
                + "FROM customers "
                + "WHERE customer_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return rs.getString("address");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public java.util.List<String[]> searchCustomers(String searchText) {

        java.util.List<String[]> customers =
                new java.util.ArrayList<>();

        String sql =
                "SELECT customer_id, first_name, last_name "
                + "FROM customers "
                + "WHERE is_archived = 0 "
                + "AND (first_name LIKE ? "
                + "OR last_name LIKE ? "
                + "OR contact_number LIKE ? "
                + "OR CONCAT(first_name, ' ', last_name) LIKE ?) "
                + "ORDER BY first_name, last_name";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String search = "%" + searchText + "%";

            stmt.setString(1, search);
            stmt.setString(2, search);
            stmt.setString(3, search);
            stmt.setString(4, search);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    String[] customer = {
                        String.valueOf(
                                rs.getInt("customer_id")
                        ),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                    };

                    customers.add(customer);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }
}