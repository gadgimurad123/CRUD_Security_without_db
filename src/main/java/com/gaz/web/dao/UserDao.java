package com.gaz.web.dao;

import com.gaz.web.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User getUserByName(String name);

    public Map<String, User> getAllUsers();

    public void saveUser(User user);

    public void deleteUser(String name);
}
