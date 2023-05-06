package jdbc.dao;

import database.Database;

import java.sql.*;

public class AlbumDAO {
    public void create(int releaseYear, String title, String artistName, String genreName) throws SQLException {
        Connection con = Database.getDataSource().getConnection();
        //daca numele albumului exista deja in baza de date, nu se mai adauga
        if(findByName(title) != null) {
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
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
