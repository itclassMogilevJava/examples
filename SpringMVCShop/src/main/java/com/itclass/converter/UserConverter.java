package com.itclass.converter;

import com.itclass.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class UserConverter implements ResultSetExtractor<Optional<User>> {

    @Override
    public Optional<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = null;
        if (resultSet.next()) {
            user = User.builder()
                    .id(resultSet.getLong("id"))
                    .login(resultSet.getString("login"))
                    .password(resultSet.getString("password"))
                    .build();
        }
        return Optional.ofNullable(user);
    }
}
