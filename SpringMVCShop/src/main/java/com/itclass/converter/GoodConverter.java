package com.itclass.converter;

import com.itclass.domain.Good;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class GoodConverter implements ResultSetExtractor<Optional<Good>>, RowMapper<Good> {

    @Override
    public Optional<Good> extractData(ResultSet rs) throws SQLException, DataAccessException {
        if (rs.next()) {
            return Optional.ofNullable(mapRow(rs, rs.getRow()));
        }
        return Optional.empty();
    }

    @Override
    public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
        Good good = new Good();
        good.setId(rs.getLong("id"));
        good.setPrice(rs.getDouble("price"));
        good.setTitle(rs.getString("title"));
        return good;
    }
}
