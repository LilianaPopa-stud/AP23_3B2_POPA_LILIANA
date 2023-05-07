import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jdbc.entities.Album;
import jdbc.entities.Artist;
import jdbc.entities.Genre;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportTool {
    private final String csvPath;
    private final List<Album> albums = new ArrayList<>();
    private final List<Artist> artists = new ArrayList<>();
    private final List<Genre> genres = new ArrayList<>();

    public ImportTool(String csvPath) {
        this.csvPath = csvPath;
    }

    /**
     * Reads the CSV file and populates the albums, artists and genres lists
     *
     * @throws IOException
     * @throws CsvValidationException
     */
    public void importData() throws IOException, CsvValidationException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("albumlist.csv").getFile());
        FileReader fileReader = new FileReader(file);
        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;

        int albumId = 0;
        int artistId = 0;
        int genreId = 0;
        int k = 0;
        while ((nextRecord = csvReader.readNext()) != null) {
            if (k != 0) { //first line is header
                String albumYear = nextRecord[1];
                String albumTitle = nextRecord[2];
                String albumArtist = nextRecord[3];
                String albumGenre = nextRecord[4];

                Album album = new Album(albumId, albumYear, albumTitle, albumArtist, albumGenre);
                if (!albums.contains(album)) {
                    albums.add(album);
                    albumId++;
                }
                Artist artist = new Artist(artistId, albumArtist);
                if (!artists.contains(artist)) {
                    artists.add(artist);
                    artistId++;
                }
                Genre genre = new Genre(genreId, albumGenre);
                if (!genres.contains(genre)) {
                    genres.add(genre);
                    genreId++;
                }
            }
            k++;
        }
        csvReader.close();
        fileReader.close();
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void printAlbums() {
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    public void printArtists() {
        for (Artist artist : artists) {
            System.out.println(artist);
        }
    }

    public void printGenres() {
        for (Genre genre : genres) {
            System.out.println(genre);
        }
    }

}
