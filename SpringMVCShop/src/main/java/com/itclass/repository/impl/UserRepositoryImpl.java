package com.itclass.repository.impl;

import com.itclass.converter.UserConverter;
import com.itclass.domain.User;
import com.itclass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private static final String FIND_BY_LOGIN_SQL = "select * from users where login = ?";
    private static final String SAVE_SQL = "insert into users(login, password) values(?, ?)";

    private final JdbcTemplate jdbcTemplate;
    private final UserConverter userConverter;

    @Override
    public Optional<User> findByLogin(String login) {
        return jdbcTemplate.query(FIND_BY_LOGIN_SQL, userConverter, login);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(SAVE_SQL, user.getLogin(), user.getPassword());
    }
}
