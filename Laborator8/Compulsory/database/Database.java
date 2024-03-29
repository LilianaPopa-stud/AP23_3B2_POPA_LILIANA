package database;

import java.sql.*;
public class Database {
    private static final String URL =
            "jdbc:sqlite:db\\database.db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
