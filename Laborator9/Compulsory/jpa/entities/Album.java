package jpa.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Albums.findAll",
                query = "select e from Albums e order by e.name"),
})
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private String release_year;

    @Column(name ="artist")
    private String artist;

    @Column(name ="genre")
    private String genre;
    //constructors, getters, setters, toString

}
