package pjwstk.fryger.computerstore.repository;

import org.hibernate.exception.ConstraintViolationException;
import pjwstk.fryger.computerstore.entity.Comment;
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
public class CommentRepository implements Repository<Comment> {

    @Resource
    private UserTransaction userTransaction;

    @Inject
    private EntityManager en;


    public CommentRepository() {
    }

    @Override
    public Comment getById(Long id) {

        Comment temp = null;
        try {
            temp = en.find(Comment.class, id);
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found");
        }

        return temp;
    }

    @Override
    public List<Comment> query(Query query)
    {
        CriteriaBuilder builder = en.getCriteriaBuilder();
        CriteriaQuery<Comment> criteria = builder.createQuery(Comment.class);

        Root<Comment> rootEntry = criteria.from(Comment.class);


        return en.createQuery(query.toQuery(rootEntry, criteria, builder))
                .getResultList();
    }

    @Override
    public Long add(Comment item)
    {

        return null;// TODO: 24.05.2018  ;
    }

    @Override
    public void update(Comment item,Long id)
    {
        // TODO: 24.05.2018  ;
    }

    @Override
    public void remove(Long id)
    {
        try {

            userTransaction.begin();

            Comment temp = this.getById(id);

            en.remove(temp);


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException e) {

            throw new RuntimeException("Not remove ");

        } finally {

            en.close();

        }
    }



}
