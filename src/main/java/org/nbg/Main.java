package org.nbg;
import java.sql.Connection;
import java.sql.SQLException;
import org.nbg.database.connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting application...");

        try (Connection conn = connection.getConnection()) {
            if (conn != null) {
                System.out.println("Database connection successful!");

                boolean neilExists = connection.checkUserExists("neil");
                System.out.println("Checking user existence... Is 'neil' in the database? " + neilExists);
            }
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }
}