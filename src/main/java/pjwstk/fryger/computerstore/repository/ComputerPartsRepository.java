package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.entity.Part;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ComputerPartsRepository implements Repository<Part>
{



    private EntityManager en;



    @Inject
    public ComputerPartsRepository(EntityManager entityManager)
    {
        en = entityManager;
    }

    @Override
    public Part getById(Long id)
    {
       return  en.find(Part.class,id);
    }


    @Override
    public List<Part> query(CriteriaQuery query) {


        return en.createQuery(query).getResultList();


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
