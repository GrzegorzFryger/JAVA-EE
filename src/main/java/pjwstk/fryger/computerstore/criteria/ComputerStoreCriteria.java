package pjwstk.fryger.computerstore.criteria;

import pjwstk.fryger.computerstore.entity.ComputerPartCategory;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.entity.Part_;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ComputerStoreCriteria implements Criteria<Part>
{

    private EntityManager entityManager;
    private CriteriaBuilder builder;
    private CriteriaQuery<Part> criteria;
    private Root<Part> rootEntry;


    @Inject
    public ComputerStoreCriteria(EntityManager entityManager)
    {
       this.entityManager = entityManager;
       this.builder = entityManager.getCriteriaBuilder();
       this.criteria = builder.createQuery(Part.class);
       this.rootEntry = criteria.from(Part.class);

    }

    public CriteriaQuery<Part> allEntries()
    {

       


        return criteria.select(rootEntry);


    }

    public CriteriaQuery<Part> findByName(String name )
    {

        criteria.where(builder.equal(rootEntry.get(Part_.name),name));



         return criteria;
    }


    public CriteriaQuery<Part> findByCategory(ComputerPartCategory category)
    {


        criteria.where(builder.equal(rootEntry.get(Part_.category),category));




        return criteria;
    }


    public CriteriaQuery<Part> findByPrice(int from, int to)
    {




        criteria.where(builder.between(rootEntry.get(Part_.price), from,to));



        return criteria;
    }

}
