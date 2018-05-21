package pjwstk.fryger.computerstore.repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface Repository<T>
{

    T getById(Long id);

    List<T> query(CriteriaQuery query);

    void add(T item);

    void update(T item);

    void remove(T item);



}
