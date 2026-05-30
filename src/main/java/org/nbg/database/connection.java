package org.nbg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "chrollos"; // Your macOS superuser name
    private static final String PASSWORD = "neilbrags062004"; // Your password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean checkUserExists(String username) {
        String query = "SELECT EXISTS(SELECT 1 FROM pg_roles WHERE rolname = ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error while checking user existence: " + e.getMessage());
        }
        return false;
    }
}
