package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.criteria.ComputerStoreCriteria;
import pjwstk.fryger.computerstore.entity.Part;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ComputerPartsRepositoryImplementation implements IRepository<Part>
{



    private EntityManager en;

    @Inject
    ComputerStoreCriteria criteria;

    @Inject
    public ComputerPartsRepositoryImplementation(EntityManager entityManager)
    {
        en = entityManager;
    }

    @Override
    public Part getById(Long id)
    {
       return  en.find(Part.class,id);
    }


    @Override
    public List<Part> query() {

        return null;
        //return en.createQuery(criteria.allEntries(en.getCriteriaBuilder())).getResultList();
    }

    @Override
    public void add(Part item) {

    }

    @Override
    public void update(Part item) {

    }

    @Override
    public void remove(Part item) {

    }
}
