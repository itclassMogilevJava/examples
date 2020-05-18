package com.itclass.repository.impl;

import com.itclass.converter.GoodConverter;
import com.itclass.domain.Good;
import com.itclass.repository.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GoodRepositoryImpl implements GoodRepository {
    private static final String FIND_ALL_SQL = "select * from goods";
    private static final String FIND_BY_ID_SQL = "select * from goods where id = ?";

    private final JdbcTemplate jdbcTemplate;
    private final GoodConverter goodConverter;

    @Override
    public List<Good> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, (RowMapper<Good>) goodConverter);
    }

    @Override
    public Optional<Good> findById(Long id) {
        return jdbcTemplate.query(FIND_BY_ID_SQL, (ResultSetExtractor<Optional<Good>>) goodConverter, id);
    }
}
