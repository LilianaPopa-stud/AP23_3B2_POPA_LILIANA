package jdbc.dao;

import database.Database;

import java.sql.*;

public class GenreDAO {

    /**
     * Creates a genre in the database
     *
     * @param name the name of the genre
     * @throws SQLException
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getDataSource().getConnection();
        //daca numele genului exista deja in baza de date, nu se mai adauga
        if (findByName(name) != null) {
            return;
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    /**
     * Finds a genre by its name
     *
     * @param name the name of the genre
     * @return the id of the genre
     * @throws SQLException
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * Finds a genre by its id
     *
     * @param id the id of the genre
     * @return the name of the genre
     * @throws SQLException
     */
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
