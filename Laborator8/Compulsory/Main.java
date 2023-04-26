import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.GenreDAO;
import database.Database;

import java.sql.*;
public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock"); //TODO: Funk, Soul, Pop
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
                    Database.getConnection().commit();
            //print all the artists in the database
            System.out.println("Artists:");
            try (Statement stmt = Database.getConnection().createStatement();
                 ResultSet rs = stmt.executeQuery("select * from artists")) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2));
                }
            }
            //print all the albums in the database
            System.out.println("Albums:");
            try (Statement stmt = Database.getConnection().createStatement();
                 ResultSet rs = stmt.executeQuery("select * from albums")) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
                }
            }
            //print all the genres in the database
            System.out.println("Genres:");
            try (Statement stmt = Database.getConnection().createStatement();
                 ResultSet rs = stmt.executeQuery("select * from genres")) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2));
                }
            }


            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
