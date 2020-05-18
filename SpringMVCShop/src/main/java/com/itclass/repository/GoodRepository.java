package com.itclass.repository;

import com.itclass.domain.Good;

import java.util.List;
import java.util.Optional;

public interface GoodRepository {

    List<Good> findAll();
    Optional<Good> findById(Long id);
}
