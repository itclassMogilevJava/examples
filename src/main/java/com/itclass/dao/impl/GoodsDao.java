package com.itclass.dao.impl;

import com.itclass.dao.BaseDao;
import com.itclass.model.Good;
import com.itclass.model.User;
import com.itclass.utils.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GoodsDao implements BaseDao<Good, Long> {
    private static final String SQL_SELECT_ALL = "SELECT * FROM goods";

    @Override
    public List<Good> getAll() {
        List<Good> goods = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.INSTANCE.getConnection().prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    goods.add(parseSet(resultSet));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }

    private Good parseSet(ResultSet resultSet) throws SQLException {
        Long goodId = resultSet.getLong(1);
        String title = resultSet.getString(2);
        double password = resultSet.getDouble(3);
        return new Good(goodId, title, password);
    }

    @Override
    public Good getById(Long id) {
        return null;
    }
}
