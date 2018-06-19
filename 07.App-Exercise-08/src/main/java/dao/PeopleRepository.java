package dao;

import entity.Person;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


import query.Query;
import javax.persistence.RollbackException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PeopleRepository implements Repository<Person>
{
    @Inject
    private EntityManager entityManager;
    @Resource
    private UserTransaction userTransaction;

    private CriteriaBuilder builder;
    private CriteriaQuery<Person> criteria;
    private Root <Person> rootEntry ;




    public PeopleRepository() {
    }

    @PostConstruct
    private void init()
    {

        this.builder =  entityManager.getCriteriaBuilder();
        this.criteria = builder.createQuery(Person.class);
        this.rootEntry =  criteria.from(Person.class);
    }

    @Override
    public Person find(Long id) {
       return  entityManager.find(Person.class,id);
    }

    @Override
    public List<Person> query(Query query) {
        

        return entityManager.createQuery(query.toQuery(rootEntry, criteria, builder))
                .getResultList();
    }

    public List<Person> getlimitResult(int from, int to)
    {


        return    entityManager.createQuery(criteria.select(rootEntry))
                .setFirstResult(from).setMaxResults(to).getResultList();
    }

    @Override
    public Long add(Person entity)
    {

        beginTransaction();
        entity = entityManager.merge(entity);
        commitTransaction();
        return entity.getId();
    }

    @Override
    public void update(Long id, Person items)
    {
        Person personTemp = find(id);
        beginTransaction();
        personTemp = items;
        personTemp.setId(id);
        entityManager.merge(personTemp);
        commitTransaction();


    }

    @Override
    public void remove(Long id)
    {
        Person personTemp = find(id);
        beginTransaction();
        entityManager.remove(personTemp);
        commitTransaction();


    }



    private void beginTransaction()  {
        try {
           userTransaction.begin();
        } catch (SystemException | NotSupportedException e) {
            rollBackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            userTransaction.commit();
        } catch ( HeuristicRollbackException | javax.transaction.RollbackException
                | HeuristicMixedException | SystemException e) {
            rollBackTransaction();
        }
    }

    private void rollBackTransaction() {
        try {
            userTransaction.rollback();
        } catch (SystemException  e) {
            e.printStackTrace();
        }
    }

}
