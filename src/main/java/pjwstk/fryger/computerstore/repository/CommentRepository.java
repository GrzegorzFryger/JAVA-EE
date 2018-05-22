package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.query.Query;

import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class CommentRepository implements Repository<Comment> {




    public CommentRepository() {
    }

    @Override
    public Comment getById(Long id) {
        return null;
    }

    @Override
    public List<Comment> query(Query query) {
        return null;
    }

    @Override
    public Long add(Comment item) {

        return null;
    }

    @Override
    public void update(Comment item) {

    }

    @Override
    public void remove(Comment item) {

    }
}
