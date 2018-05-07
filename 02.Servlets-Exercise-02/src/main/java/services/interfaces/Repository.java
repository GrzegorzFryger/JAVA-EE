package services.interfaces;

import java.util.List;

public interface Repository<T> {
    T getById(Long id);

    List<T> getAll();

    void add(T item );

    void update(T item);

    void remove(T item);


}
