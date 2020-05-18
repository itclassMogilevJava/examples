package com.itclass.service;

import com.itclass.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByLogin(String login);
    boolean login(String login, String password);
    boolean save(String login, String password);
}
