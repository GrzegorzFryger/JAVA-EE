package dao;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class EntityMenagerProducer
{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Produces

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(
            @Disposes  EntityManager entityManager) {
        entityManager.close();
    }

}
