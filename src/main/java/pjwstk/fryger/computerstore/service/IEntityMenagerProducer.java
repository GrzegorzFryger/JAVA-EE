package pjwstk.fryger.computerstore.service;

import javax.persistence.EntityManager;

public interface IEntityMenagerProducer
{

    public EntityManager create();


    public void dispose( EntityManager entityManager);

}
