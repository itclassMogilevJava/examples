package com.itclass.service;

import com.itclass.dao.impl.UserDao;
import com.itclass.model.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao = new UserDao();

    public boolean isUserExists(String login) {
        Optional<User> optionalUser = userDao.getByLogin(login);
        return optionalUser.isPresent();
    }
}
