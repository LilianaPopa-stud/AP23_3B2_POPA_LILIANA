import com.opencsv.exceptions.CsvValidationException;
import database.Database;

import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String args[]) throws CsvValidationException, IOException {
     /*   EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();


        jpa.entities.Artist artist = new jpa.entities.Artist(1L, "Pink Floyd");
        ArtistRepository artistRepository = new ArtistRepository(em);
        artistRepository.create(artist);
        System.out.println(artistRepository.findById(1L, jpa.entities.Artist.class));
        System.out.println(artistRepository.findByName("Pink", jpa.entities.Artist.class)); */
   /*     try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock");
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
            } */


     /*       Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } */

        try {
            // Obține o conexiune din pool-ul HikariCP
            Connection connection = Database.getDataSource().getConnection();

            // Verifică dacă conexiunea este deschisă
            if (connection.isValid(1)) {
                System.out.println("Conexiunea la baza de date funcționează corect!");
            } else {
                System.out.println("Conexiunea la baza de date este invalidă!");
            }

            // Închide conexiunea
            connection.close();
        } catch (SQLException e) {
            System.err.println("Eroare la conectarea la baza de date: " + e.getMessage());
        }
        ImportTool importTool = new ImportTool("albumlist.csv");
        importTool.importData();
        importTool.printAlbums();
        importTool.printArtists();
        importTool.printGenres();
    }
}
