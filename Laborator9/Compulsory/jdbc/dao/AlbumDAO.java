package jdbc.dao;

import database.Database;

import java.sql.*;

public class AlbumDAO {

    /**
     * Creates an album in the database
     *
     * @param releaseYear the year the album was released
     * @param title       the title of the album
     * @param artistName  the name of the artist
     * @param genreName   the name of the genre
     * @throws SQLException
     */
    public void create(int releaseYear, String title, String artistName, String genreName) throws SQLException {
        Connection con = Database.getDataSource().getConnection();
        //daca numele albumului exista deja in baza de date, nu se mai adauga
        if (findByName(title) != null) {
            return;
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist, genre) values (?, ?, ?, ?)")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setString(3, artistName);
            pstmt.setString(4, genreName);
            pstmt.executeUpdate();
        }
    }

    /**
     * Finds an album by its name
     *
     * @param name the name of the album
     * @return the id of the album
     * @throws SQLException
     */
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    /**
     * Finds an album by its id
     *
     * @param id the id of the album
     * @return the name of the album
     * @throws SQLException
     */
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
