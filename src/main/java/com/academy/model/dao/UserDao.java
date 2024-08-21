package com.academy.model.dao;

import com.academy.model.entity.User;
import java.util.List;

public interface UserDao extends DefaultDao<User> {
    public List<User> findByUsername(String name);

    public List<User> findByUserSurname(String surname);

    public User findByPhone(String phone);
}
