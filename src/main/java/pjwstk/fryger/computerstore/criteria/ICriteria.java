package pjwstk.fryger.computerstore.criteria;

import javax.persistence.criteria.CriteriaQuery;

public interface ICriteria<T>
{


    public CriteriaQuery<T> allEntries();

}
