package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.entity.ComputerPartCategory;
import pjwstk.fryger.computerstore.entity.Part;
import pjwstk.fryger.computerstore.query.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;



public  class PartsRepository implements Repository<Part>
{





    private EntityManager en;

    private CriteriaBuilder builder;
    private CriteriaQuery<Part> criteria;
    private Root<Part> rootEntry;



    @Inject
    public PartsRepository(EntityManager entityManager)
    {
        en = entityManager;
        this.builder = entityManager.getCriteriaBuilder();
        this.criteria = builder.createQuery(Part.class);
        this.rootEntry = criteria.from(Part.class);
    }

    @Override
    public Part getById(Long id)
    {
       return  en.find(Part.class,id);
    }


    @Override
    public List<Part> query(Query query) {




        return  en
                .createQuery(query.toQuery(rootEntry,criteria,builder))
                .getResultList();


    }

    @Override
    public Long add(Part item)
    {


        List<Comment> b = new ArrayList<>();
        Comment c = new Comment();
        c.setDate(55);
        c.setId(Long.valueOf(2));
        c.setComment("sad");
        c.setName("asd");
        c.setTitle("sad");
        b.add(c);

        Part p = new Part();
        p.setId(Long.valueOf(1));
       p.setCategory(ComputerPartCategory.GRAPHIC_CARD);
        p.setDescription("asd");
        p.setName("test");
        p.setPrice(188);
        p.setComments(b);






            en.persist(p);



        return item.getId();

    }

    @Override
    public void update(Part item) {

    }

    @Override
    public void remove(Part item) {

    }
}
