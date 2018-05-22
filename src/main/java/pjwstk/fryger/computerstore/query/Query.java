package pjwstk.fryger.computerstore.query;

import pjwstk.fryger.computerstore.entity.Part;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public interface Query<T>
{
    CriteriaQuery<T> toQuery(Root<Part> root, CriteriaQuery query, CriteriaBuilder cBuldier);

}
