package jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceSetup{
    private static EntityManagerFactory emfInstance;

    private PersistenceSetup() {}

    /**
     * @return an EntityManagerFactory
     */
    public static synchronized EntityManagerFactory getInstance() {
        if (emfInstance == null) {
            emfInstance = Persistence.createEntityManagerFactory("myPersistenceUnit");
        }
        return emfInstance;
    }
}
