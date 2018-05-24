package pjwstk.fryger.computerstore.repository;

import pjwstk.fryger.computerstore.query.Query;

import java.util.List;

public interface Repository<T>
{

    T getById(Long id);

    List<T> query( Query query);

    Long add(T item);

    void update(T item, Long id);

    void remove(Long id);





}
