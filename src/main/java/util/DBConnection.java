package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_access", "postgres", "root");
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Database connection failed");
        }
    }
}

