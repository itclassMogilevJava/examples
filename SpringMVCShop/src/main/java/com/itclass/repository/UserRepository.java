package com.itclass.repository;

import com.itclass.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByLogin(String login);
    void save(User user);
}
