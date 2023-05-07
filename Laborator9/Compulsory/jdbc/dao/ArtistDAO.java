package jdbc.dao;

import database.Database;

import java.sql.*;

public class ArtistDAO {

    /**
     * Creates an artist in the database
     *
     * @param name the name of the artist
     * @throws SQLException
     */
    public void create(String name) throws SQLException {
        Connection con = Database.getDataSource().getConnection();
        if (findByName(name) != null) {
            return;
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    /**
     * Finds an artist by its name
     *
     * @param name the name of the artist
     * @return the id of the artist
     * @throws SQLException
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * Finds an artist by its id
     *
     * @param id the id of the artist
     * @return the name of the artist
     * @throws SQLException
     */
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
