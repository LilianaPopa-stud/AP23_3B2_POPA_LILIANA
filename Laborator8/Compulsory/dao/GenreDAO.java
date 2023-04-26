package dao;

import database.Database;

import java.sql.*;

public class GenreDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        //daca numele genului exista deja in baza de date, nu se mai adauga
        if(findByName(name) != null) {
            return;
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
