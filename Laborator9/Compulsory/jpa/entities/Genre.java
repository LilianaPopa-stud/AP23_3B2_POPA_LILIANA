package jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genres.findAll",
                query = "select e from Genres e order by e.name"),
})
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    //constructors, getters, setters, toString

}