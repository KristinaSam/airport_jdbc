package com.academy.model.dao;

import java.util.List;

public interface DefaultDao<T> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);

    List<T> findAll();
}
