package pjwstk.fryger.computerstore.criteria;

import pjwstk.fryger.computerstore.entity.Part;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ComputerStoreCriteria implements ICriteria<Part>
{

   private EntityManager entityManager;

    @Inject
    public ComputerStoreCriteria(EntityManager entityManager)
    {
       this.entityManager =entityManager;
    }

    public CriteriaQuery<Part> allEntries()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Part> cq = cb.createQuery(Part.class);
        Root<Part> rootEntry = cq.from(Part.class);



        return cq.select(rootEntry);


    }

}
