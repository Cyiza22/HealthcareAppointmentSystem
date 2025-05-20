package org.example;
import java.util.List;
public interface Repository <T, K> {
    List<T> findAll();
    T findById(K id);
    void deleteById(K id);
    void create(T t);
    void update(T t, K id);
}
