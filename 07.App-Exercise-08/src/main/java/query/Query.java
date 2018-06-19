package query;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public interface Query<T>
{
    CriteriaQuery<T> toQuery(Root<T> root, CriteriaQuery query, CriteriaBuilder cBuldier);

}
