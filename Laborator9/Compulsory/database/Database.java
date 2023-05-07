package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:sqlite:db\\database.db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private static HikariDataSource dataSource;

    /**
     * @return a connection to the database
     */
    public static HikariDataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(URL);
            config.setUsername(USER);
            config.setPassword(PASSWORD);
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }

    private Database() {
    }

    /**
     * @return a connection to the database
     */
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    /**
     * Creates a connection to the database
     */
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Closes the connection to the database
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Commits the changes made to the database
     */
    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
