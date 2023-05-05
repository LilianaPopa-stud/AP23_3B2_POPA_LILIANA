package entities;

public class Album extends ModelObject {
    private int id;
    private int releaseYear;
    private String title;
    private String artistName;
    private String genreName;

    public Album(int id, int releaseYear, String title, String artistName, String genreName) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artistName = artistName;
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenreName() {
        return genreName;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artistName='" + artistName + '\'' +
                ", genreName='" + genreName + '\'' +
                '}';
    }



}
