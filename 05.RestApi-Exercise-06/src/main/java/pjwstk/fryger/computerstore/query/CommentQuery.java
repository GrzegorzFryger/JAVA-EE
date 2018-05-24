package pjwstk.fryger.computerstore.query;

import pjwstk.fryger.computerstore.entity.Comment;
import pjwstk.fryger.computerstore.entity.Part;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CommentQuery
{

    public static Query<Comment> getAllComment()
    {
        return new Query<Comment>() {

            @Override
            public CriteriaQuery<Comment> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier) {

                return query.select(root);
            }
        };
    }

}
