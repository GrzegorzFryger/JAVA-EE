package pjwstk.fryger.computerstore.repository;

import org.hibernate.exception.ConstraintViolationException;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.query.Query;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.*;
import java.util.List;


@Named
@RequestScoped
public  class PartsRepository implements Repository<Part>
{


    @Resource
    private UserTransaction userTransaction;

    @Inject
    private EntityManager en;


    public PartsRepository()
    {

    }



    @Override
    public Part getById(Long id)
    {
       return  en.find(Part.class,id);
    }


    @Override
    public List<Part> query(Query query) {


        CriteriaBuilder builder = en.getCriteriaBuilder();
        CriteriaQuery<Part> criteria = builder.createQuery(Part.class);;
        Root<Part> rootEntry = criteria.from(Part.class);



        return  en.createQuery(query.toQuery(rootEntry,criteria,builder))
                .getResultList();


    }

    @Override
    public Long add(Part item)
    {
        Part managedEntity = null;

        try {

            userTransaction.begin();

             managedEntity = en.merge(item);


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException  e)
        {

            e.printStackTrace();

        }

        return managedEntity.getId();

    }

    @Override
    public void update(Part item)
    {

      Part dbPart =  en.getReference(Part.class,item.getId());





    }

    @Override
    public void remove(Part item) {

    }
}
