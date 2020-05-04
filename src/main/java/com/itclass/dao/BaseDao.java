package com.itclass.dao;

import java.util.List;

public interface BaseDao<E, K> {

    List<E> getAll();

    E getById(K id);

}
