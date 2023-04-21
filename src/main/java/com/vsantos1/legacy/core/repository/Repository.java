package com.vsantos1.legacy.core.repository;


import java.util.List;

public interface Repository<T, ID> {

    T save(T entity);

    T update(T entity);

    T findById(ID id, Class<T> entityClass);


    List<T> findAll(Class<T> entityClass);

    void delete(ID id, Class<T> entityClass);

    void deleteById(ID id);
}
