package pjwstk.fryger.computerstore.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityMenagerProducer
{
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @RequestScoped
    public EntityManager create()
    {
        return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes EntityManager entityManager)
    {
        if(entityManager.isOpen())
        {
            entityManager.close();
        }
    }

}
