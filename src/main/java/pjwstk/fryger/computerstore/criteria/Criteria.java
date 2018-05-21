package pjwstk.fryger.computerstore.criteria;

import javax.persistence.criteria.CriteriaQuery;

public interface Criteria<T>
{


    public CriteriaQuery<T> allEntries();

}
