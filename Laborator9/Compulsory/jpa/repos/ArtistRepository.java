package jpa.repos;

import jpa.entities.Artist;

import javax.persistence.EntityManager;

public class ArtistRepository extends GenericRepository<Artist> {

    public ArtistRepository(EntityManager entityManager) {
        super(entityManager);
    }
}

