package jpa.repos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public abstract class GenericRepository<T> {
    private final EntityManager entityManager;

    public GenericRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T findById(Long id, Class<T> entityClass) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findByName(String name, Class<T> entityClass) {
        Query query = entityManager.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
