package com.itclass.dao.impl;

import com.itclass.dao.BaseDao;
import com.itclass.model.User;
import com.itclass.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class UserDao implements BaseDao<User, Long> {

    private static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM users";

    public Optional<User> getByLogin(String login) {
        try (PreparedStatement statement = ConnectionManager.INSTANCE.getConnection().prepareStatement(SQL_SELECT_BY_LOGIN)) {
            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(parseSet(resultSet));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.INSTANCE.getConnection().prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(parseSet(resultSet));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }


    private User parseSet(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong(1);
        String login = resultSet.getString(2);
        String password = resultSet.getString(3);
        return new User(userId, login, password);
    }

    @Override
    public User getById(Long id) {
        throw new UnsupportedOperationException();
    }
}
