package com.mycompany.waterrefillingstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public String[] login(String username, String password) {

        String sql =
                "SELECT user_id, username, role "
                + "FROM users "
                + "WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    String[] user = {
                        String.valueOf(rs.getInt("user_id")),
                        rs.getString("username"),
                        rs.getString("role")
                    };

                    return user;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
