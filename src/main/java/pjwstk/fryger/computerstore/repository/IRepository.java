package pjwstk.fryger.computerstore.repository;

import java.util.List;

public interface IRepository <T >
{

    T getById(Long id);

    List<T> query();

    void add(T item);

    void update(T item);

    void remove(T item);



}
