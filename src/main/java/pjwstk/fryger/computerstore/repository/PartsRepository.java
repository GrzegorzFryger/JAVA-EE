package pjwstk.fryger.computerstore.repository;

import org.hibernate.exception.ConstraintViolationException;
import pjwstk.fryger.computerstore.entity.Comment;
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
import java.util.stream.Collectors;


@Named
@RequestScoped
public class PartsRepository implements Repository<Part> {


    @Resource
    private UserTransaction userTransaction;

    @Inject
    private EntityManager en;


    public PartsRepository() {

    }


    @Override
    public Part getById(Long id) {
        Part temp = null;
        try {
            temp = en.find(Part.class, id);
        } catch (NullPointerException e) {
            throw new RuntimeException("Not found");
        }

        return temp;

    }


    @Override
    public List<Part> query(Query query) {


        CriteriaBuilder builder = en.getCriteriaBuilder();
        CriteriaQuery<Part> criteria = builder.createQuery(Part.class);

        Root<Part> rootEntry = criteria.from(Part.class);


        return en.createQuery(query.toQuery(rootEntry, criteria, builder))
                .getResultList();


    }

    @Override
    public Long add(Part item) {
        Part managedEntity = null;

        try {

            userTransaction.begin();

            managedEntity = en.merge(item);
            //en.persist(item);


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException e) {

            e.printStackTrace();

        } finally {

            en.close();
        }

        return managedEntity.getId();

    }

    @Override
    public void update(Part item, Long id) {


        try {

            userTransaction.begin();

            Part temp = this.getById(id);

            if (temp != null && item.getId() == id) {
                temp = item;

            } else throw new RuntimeException("Null point");

            temp = en.merge(temp);


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException e) {

            e.printStackTrace();

        } finally {

            en.close();

        }


    }

    @Override
    public void remove(Long id) {

        try {

            userTransaction.begin();

            Part temp = this.getById(id);

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

    //removing references to comments

    public void remove(Long id, Long idChild) {
        try {

            userTransaction.begin();

            Part temp = this.getById(id);


            temp.getComments().remove(getCommentByID(temp, idChild));


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException e) {

            throw new RuntimeException("Not remove ");

        } finally {

            en.close();

        }

    }

    public List<Comment> getAllCommentPart(Long id) {
        return this.getById(id).getComments();
    }

    public void addCommentToPart(Long id, Comment comment) {

        Part temp = this.getById(id);

        if (temp.getComments().stream().anyMatch(com -> com.getId().equals(comment.getId()))) {
            throw new RuntimeException("Value existing");
        }

        try {

            userTransaction.begin();


            temp.getComments().add(comment);

            en.merge(temp);


            userTransaction.commit();

        } catch (NotSupportedException | SystemException | SecurityException | IllegalStateException |
                RollbackException | HeuristicMixedException | HeuristicRollbackException |
                ConstraintViolationException e) {

            throw new RuntimeException("Db errot");

        } finally {

            en.close();

        }


    }

    protected Comment getCommentByID(Part item, Long id) {
        return item.getComments().stream().filter(comment -> comment.getId().equals(id)).collect(
                Collectors.collectingAndThen(
                        Collectors.toList(), list -> {
                            if (list.size() != 1) {
                                throw new RuntimeException();
                            }
                            return list.get(0);
                        }
                )
        );
    }
}
