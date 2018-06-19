package dao;


import query.Query;

import java.util.List;
import java.util.function.Consumer;

public interface Repository<T>
{

    T find(Long id);

    List<T> query(Query query);

    Long add(T entity);

    void update(Long id, T  items );

    void remove(Long id);





}